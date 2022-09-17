package com.example.document_management_system.Web;


import com.example.document_management_system.Model.Enum.DocumentStatus;
import com.example.document_management_system.Model.dokument;
import com.example.document_management_system.Model.rekord_na_sledenje;
import com.example.document_management_system.Service.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/document")
public class Document {
    private final detailedView_docService detailedView_docService;
    private final PromeniVoCelPeriodService promeniVoCelPeriodService;
    private final RekordNaSledenjeService rekordNaSledenjeService;
    private final OddelService oddelService;
    private final DocumentService documentService;
    private final detailedView_logService detailedView_logService;

    public Document(com.example.document_management_system.Service.detailedView_docService detailedView_docService, PromeniVoCelPeriodService promeniVoCelPeriodService, RekordNaSledenjeService rekordNaSledenjeService, OddelService oddelService, DocumentService documentService, com.example.document_management_system.Service.detailedView_logService detailedView_logService) {
        this.detailedView_docService = detailedView_docService;
        this.promeniVoCelPeriodService = promeniVoCelPeriodService;
        this.rekordNaSledenjeService = rekordNaSledenjeService;
        this.oddelService = oddelService;
        this.documentService = documentService;
        this.detailedView_logService = detailedView_logService;
    }

    //client
    @GetMapping("/{id}")
    public String getDetaildViewDocClient(Model model, @PathVariable int id, HttpServletRequest req, HttpServletResponse resp){
        String client = req.getSession().getAttribute("client").toString();
        model.addAttribute("cel_period", promeniVoCelPeriodService.filterCelPeriodPromeniByClient(client));
        model.addAttribute("DetailedViewDocument", detailedView_docService.findAllbyDocument_Id(id));
        return "Detailed_View_Document";
    }

    //employee
    @GetMapping("/employee/{id}")
    public String getDetaildViewDocEmployee(Model model, @PathVariable int id, HttpServletRequest req, HttpServletResponse resp){
        model.addAttribute("employee", req.getSession().getAttribute("employee"));
      model.addAttribute("DetailedViewDocument", detailedView_docService.findAllbyDocument_Id(id));
      return "Detailed_View_DocumentEmployee";
    }

    //employee
    @GetMapping("/add-record-form/{id_dokument}/{id_klient}")
    public String getAddRecordPage(@PathVariable Integer id_dokument,
                                @PathVariable Integer id_klient,
                                HttpServletRequest req,
                                Model model)
    {
        model.addAttribute("Dokument_id",id_dokument );
        model.addAttribute("DocumentName", this.documentService.findByid(id_dokument));
        model.addAttribute("Klient_id",id_klient );
        model.addAttribute("Vraboten_id", req.getSession().getAttribute("employee"));
        model.addAttribute("statuses", DocumentStatus.values());
        return "addDocumentRecordForm";
    }


    //employee
    @PostMapping("/add-record")
    public String addRecord(
            @RequestParam Integer id_dokument,
            @RequestParam Integer id_klient,
            @RequestParam Integer id_vraboten,
            @RequestParam DocumentStatus status,
            @RequestParam("file") MultipartFile file,
            @RequestParam String komentar,
            @RequestParam String promena, Model model) throws Exception {
        if(file==null)
        {
            this.rekordNaSledenjeService.save(id_dokument, id_klient, id_vraboten, null, LocalDateTime.now(),
                    status, null, komentar, promena, null,null);
        }
        else if(file!=null)
        {
          this.rekordNaSledenjeService.save(id_dokument,id_klient,id_vraboten,LocalDateTime.now(),
                  LocalDateTime.now(),status ,file.getOriginalFilename(),komentar,promena,file,file.getContentType());
        }
        return "redirect:/document/employee/"+id_dokument;
    }

    //getAddDocumentForm
    @GetMapping("/addDocument/{client}")
    public String getAddDocumentPage(@PathVariable Integer client,
                                     Model model)
    {

        model.addAttribute("klient", client);
        model.addAttribute("oddeli", this.oddelService.findAll());
        return "addDocumentForm";

    }

    //client
    @PostMapping("/upload/{client}")
    public String uploadDocumentFromClient(@PathVariable Integer client,
                                           @RequestParam String oddel,
                                           @RequestParam("file") MultipartFile file,
                                           @RequestParam String predmet_na_dokument,
                                           Model model)
    {
        try{
            this.documentService.save(client,oddel,file.getOriginalFilename(),file.getContentType(),predmet_na_dokument, file);
            return "redirect:/client?client="+client;
        }catch (IOException e)
        {
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "addDocumentForm";
        }

    }


    //zemi dostaven file od klient
    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<ByteArrayResource> dowloadFile(@PathVariable Integer id)
    {
        dokument dokument = this.documentService.findByid(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dokument.getTip_na_dokument()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + dokument.getPredmet_na_dokument() + "\"")
                .body(new ByteArrayResource(dokument.getContent()));

    }

    //zemi dostaven file od vraboten
    @GetMapping("/downloadFile/response/{id}")
    public ResponseEntity<ByteArrayResource> dowloadFileResposne(@PathVariable Integer id)
    {
        rekord_na_sledenje rns  = this.rekordNaSledenjeService.findById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(rns.getTip_na_dokument()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\""+rns.getOdgovor_file()+ "\"")
                .body(new ByteArrayResource(rns.getContent()));

    }


    //detalen pogled za log na dokument
    @GetMapping("/log/{id_log}")
    public String getDetailedViewLogForDocument(@PathVariable Integer id_log, Model model)
    {
        model.addAttribute("Log", this.detailedView_logService.findById_rekord(id_log));
        return "DetailedViewLog";
    }




}
