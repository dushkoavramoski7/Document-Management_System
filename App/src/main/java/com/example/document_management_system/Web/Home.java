package com.example.document_management_system.Web;


import com.example.document_management_system.Model.Enum.DocumentStatus;
import com.example.document_management_system.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Home {
    private final List_doc_odKlientService list_doc_odKlientService;
    private final ListaKlientiService listaKlientiService;
    private final PromeniGrupiraniPoMesecService promeniGrupiraniPoMesecService;
    private final PromeniVoTekovenMesecService promeniVoTekovenMesecService;
    private final Vraboten_kolku_doc_uspesno_realiziralService vraboten_kolku_doc_uspesno_realiziralService;
    private final VrabotenKolkuRnsPromenilService vrabotenKolkuRnsPromenilService;
    private final VrabotenService vrabotenService;

    public Home(List_doc_odKlientService list_doc_odKlientService, ListaKlientiService listaKlientiService, PromeniGrupiraniPoMesecService promeniGrupiraniPoMesecService, PromeniVoTekovenMesecService promeniVoTekovenMesecService, Vraboten_kolku_doc_uspesno_realiziralService vraboten_kolku_doc_uspesno_realiziralService, VrabotenKolkuRnsPromenilService vrabotenKolkuRnsPromenilService, VrabotenService vrabotenService) {
        this.list_doc_odKlientService = list_doc_odKlientService;
        this.listaKlientiService = listaKlientiService;
        this.promeniGrupiraniPoMesecService = promeniGrupiraniPoMesecService;
        this.promeniVoTekovenMesecService = promeniVoTekovenMesecService;
        this.vraboten_kolku_doc_uspesno_realiziralService = vraboten_kolku_doc_uspesno_realiziralService;
        this.vrabotenKolkuRnsPromenilService = vrabotenKolkuRnsPromenilService;
        this.vrabotenService = vrabotenService;
    }

    @GetMapping("/home")
    public String getHomePageAll(Model model, HttpServletRequest req, HttpServletResponse resp)
    {
        model.addAttribute("clients", listaKlientiService.findAll());
        model.addAttribute("vraboteni", vrabotenService.findAll());
        return "Home";
    }

    @GetMapping("/client")
    public String getHomePageClient(@RequestParam Integer client ,Model model, HttpServletRequest req, HttpServletResponse resp) {

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("client", client);

        model.addAttribute("client",(int) req.getSession().getAttribute("client"));
        model.addAttribute("list_dokuemts_klient", list_doc_odKlientService.filterDocumentsByClinet(client));
        model.addAttribute("promeni", promeniGrupiraniPoMesecService.filterByMonthYear(client));
        model.addAttribute("tekovni_promeni", promeniVoTekovenMesecService.filterTekovniPromeniByClient(client));
        return "ListDocuments";
    }

    @GetMapping("/employee")
    public String getHomePageEmployee(@RequestParam Integer employee, Model model, HttpServletRequest req, HttpServletResponse resp)
    {

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("employee", employee);

        model.addAttribute("clients", list_doc_odKlientService.findAllclientsbyEmployee(employee));
        model.addAttribute("document", vraboten_kolku_doc_uspesno_realiziralService.findbyId(employee));
        model.addAttribute("rns_promeneti", vrabotenKolkuRnsPromenilService.findAllByIdVraboten(employee) );
        model.addAttribute("zadadeni", list_doc_odKlientService.findAllbyEmployee(employee));
        return  "ListDocumentsEmployee";
    }

    @GetMapping("/reports")
    public String getReportPageForClient(Model model,HttpServletRequest req, HttpServletResponse resp)
    {
        Integer client = (int) req.getSession().getAttribute("client");
       model.addAttribute("RECEIVED", this.list_doc_odKlientService.countByStatus(client, DocumentStatus.RECEIVED));
        model.addAttribute("COMPLETED", this.list_doc_odKlientService.countByStatus(client, DocumentStatus.COMPLETED));
        model.addAttribute("HAS_RESPONSE", this.list_doc_odKlientService.countByStatus(client, DocumentStatus.HAS_RESPONSE));
        model.addAttribute("IN_PROGRESS", this.list_doc_odKlientService.countByStatus(client, DocumentStatus.IN_PROGRESS));
        model.addAttribute("WAITING_OTHERS", this.list_doc_odKlientService.countByStatus(client, DocumentStatus.WAITING_OTHERS));
        model.addAttribute("DECLINED", this.list_doc_odKlientService.countByStatus(client, DocumentStatus.DECLINED));
        return "VisualisationForClient";
    }


}
