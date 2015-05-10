/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

/**
 *
 * @author Nikita
 */
public class CommandResult {
    private String CreateTime, ProcessingTime, EndingTime, ProcessingResult, DocumentNo, ProcessingResultComment, ErrorText, ProcessingReserved, operation_no;
    
    public CommandResult(){}
    public CommandResult(String operation_no){this.operation_no=operation_no; }
  
    public void setCreateTime(String CreateTime){ this.CreateTime=CreateTime;}
    public void setProcessingTime(String ProcessingTime){ this.ProcessingTime=ProcessingTime;}
    public void setEndingTime(String EndingTime){ this.EndingTime=EndingTime;}
    public void setProcessingResult(String ProcessingResult){ this.ProcessingResult=ProcessingResult;}
    public void setDocumentNo(String DocumentNo){ this.DocumentNo=DocumentNo;}
    public void setProcessingResultComment(String ProcessingResultComment){ this.ProcessingResultComment=ProcessingResultComment;}
    public void setErrorText(String ErrorText){ this.ErrorText=ErrorText;}
    public void setProcessingReserved(String ProcessingReserved){ this.ProcessingReserved=ProcessingReserved;}
    
    public String getCreateTime(){return CreateTime;}
    public String getProcessingTime(){return ProcessingTime;}
    public String getEndingTime(){return EndingTime;}
    public String getProcessingResult(){return ProcessingResult;}
    public String getDocumentNo(){return DocumentNo;}
    public String getProcessingResultComment(){return ProcessingResultComment;}
    public String getErrorText(){return ErrorText;}
    public String getProcessingReserved(){return ProcessingReserved;}

  
}

