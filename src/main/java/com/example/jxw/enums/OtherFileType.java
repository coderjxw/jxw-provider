package com.example.jxw.enums;

import java.util.Arrays;

public enum OtherFileType {
    PRE_ORDER("preOrder", 1),
    JOB_CARD("jobCard", 2),
    ADDITIONAL_JOB_CARD_WITH_CUSTOMER_SIGNATURE("additionalJobCardWithCustomerSignature", 3),
    QUOTATION_ORDER("quotationOrder", 4),
    DAS("das", 5),
    DAS_MEASURED_VALUE_IN_GUSORT_NUMBERE_TEST("dasMeasuredValueInGusortNumbereTest", 6),
    REPAIR_SUMMARY("repairSummary", 7),
    PARTS_REQUISITION("partsRequisition", 8),
    PARTS_INVOICES("partsInvoices", 9),
    FINAL_INSPECTION_SHEET("finalInspectionSheet", 10),
    INVOICES("invoices", 11),
    WARRANTY_CLAIM_ORDER("warrantyClaimOrder", 12),
    TIME_CLOCKING("timeClocking", 13),
    PHOTOS_AND_VSORT_NUMBEREO("photosAndVsortNumbereo", 14),
    TIPS_CASE_REPORT("tipsCaseReport", 15),
    TIPS_DOCUMENTS("tipsDocuments", 16),
    BATTERYR_EPORT("batteryReport", 17),
    WHEEL_ALIGNMENT_REPORT("wheelAlignmentReport", 18),
    PRE_APPROVAL_EMAIL("preApprovalEmail", 19),
    WIS_SUPPORT_DOCUMENTS("wisSupportDocuments", 20),
    WIS_SERVICE_MEDIA("wisServiceMedia", 21),
    EPC_SUPPORT_DOCUMENTS("epcSupportDocuments", 22),
    SKETCH_SHEET_FOR_PAINT_COAT("sketchSheetForPaintCoat", 23),
    RECEPTION_PROTOCAL_FOR_AC("receptionProtocalForAc", 23),
    LOG_OF_REFRIGERANT_QUANTITY("logOfRefrigerantQuantity", 25),
    DIAGNOSIS_TREE("diagnosisTree", 26),
    LAST_REPAIR_INVOICE("lastRepairInvoice", 27),
    THIRD_PARTY_INVOICES("thirdPartyInvoices", 28),
    SM_CHECKING("smChecking", 29),
    VEHICLES_PURCHASE_INVOICE("vehiclesPurchaseInvoice", 30),
    CLB_REPORT("clbReport", 31),
    MOBILITY_CASE("mobilityCase", 32),
    NEWS_CLIPS("newsClips", 33),
    CIRCUIT_DIAGRAM_WITH_MEASURED_VALUE("circuitDiagramWithMeasuredValue", 34),
    REPAIR_HISTORY("repairHistory", 35),
    START_DIAGNOSTIC_EQUIPMENT("startDiagnosticEquipment", 36),
    BATTERY_TESTER("batteryTester", 37),
    ORGANIZATION_CHART("organizationChart", 38),
    OTHERS("others", 39),
    DEFAULT("default", 40),

    STARD_INITIAL_QUICK_TEST("Initial quick test",41),
    FREEZE_DATA("Freeze data",42),
    FAULT_CCODE("Fault code",43),
    GUIDE_TEST("Guide test",44),
    CONTROL_UNIT_LOG("Control unit log",45),
    FUNCTION_CHECK("Function check",46),
    SOFTWARE_UPDATE_CODING_INITIAL_STARTUP("Software update & Coding & Initial startup",47),
    FINAL_QUICK_TEST("Final quick test",48),
    STARTD_OTHERS("startD others",49);

    private String value;
    private int sortNumber;

    OtherFileType(String value, int sortNumber) {
        this.value = value;
        this.sortNumber = sortNumber;
    }

    public int getSortNumber() {
        return sortNumber;
    }

    public String getValue() {
        return value;
    }

    public static OtherFileType getFileTypeByValue(String value) {
        return Arrays.stream(values())
                .filter(otherFileType -> otherFileType.getValue().equals(value))
                .findFirst()
                .orElse(DEFAULT);
    }

    public static OtherFileType getFileTypeByValueStartD(String value) {
        return Arrays.stream(values())
                .filter(otherFileType -> otherFileType.getValue().equals(value))
                .findFirst()
                .orElse(STARTD_OTHERS);
    }
}
