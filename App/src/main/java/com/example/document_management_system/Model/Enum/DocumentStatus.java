package com.example.document_management_system.Model.Enum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum DocumentStatus {
    COMPLETED,
    DECLINED,
    EXPIRED,
    WAITING_OTHERS,
    RECEIVED,
    HAS_RESPONSE,
    IN_PROGRESS
}
