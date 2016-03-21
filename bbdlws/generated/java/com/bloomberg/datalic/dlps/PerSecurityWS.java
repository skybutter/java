package com.bloomberg.datalic.dlps;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2014-04-30T15:30:09.000-07:00
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", name = "PerSecurityWS")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PerSecurityWS {

    @WebResult(name = "submitGetQuotesResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitGetQuotesRequest")
    public SubmitGetQuotesResponse submitGetQuotesRequest(
        @WebParam(partName = "parameters", name = "submitGetQuotesRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitGetQuotesRequest parameters
    );

    @WebResult(name = "submitGetCompanyResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitGetCompanyRequest")
    public SubmitGetCompanyResponse submitGetCompanyRequest(
        @WebParam(partName = "parameters", name = "submitGetCompanyRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitGetCompanyRequest parameters
    );

    @WebResult(name = "retrieveCancelResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveCancelResponse")
    public RetrieveCancelResponse retrieveCancelResponse(
        @WebParam(partName = "parameters", name = "retrieveCancelRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveCancelRequest parameters
    );

    @WebResult(name = "submitCancelResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitCancelRequest")
    public SubmitCancelResponse submitCancelRequest(
        @WebParam(partName = "parameters", name = "submitCancelRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitCancelRequest parameters
    );

    @WebResult(name = "submitGetAllQuotesResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitGetAllQuotesRequest")
    public SubmitGetAllQuotesResponse submitGetAllQuotesRequest(
        @WebParam(partName = "parameters", name = "submitGetAllQuotesRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitGetAllQuotesRequest parameters
    );

    @WebResult(name = "retrieveGetQuotesResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveGetQuotesResponse")
    public RetrieveGetQuotesResponse retrieveGetQuotesResponse(
        @WebParam(partName = "parameters", name = "retrieveGetQuotesRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveGetQuotesRequest parameters
    );

    @WebResult(name = "retrieveScheduledResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveScheduledResponse")
    public RetrieveScheduledResponse retrieveScheduledResponse(
        @WebParam(partName = "parameters", name = "retrieveScheduledRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveScheduledRequest parameters
    );

    @WebResult(name = "retrieveMmktBvalDealsUploadResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveMmktBvalDealsUploadResponse")
    public RetrieveMmktBvalDealsUploadResponse retrieveMmktBvalDealsUploadResponse(
        @WebParam(partName = "parameters", name = "retrieveMmktBvalDealsUploadRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveMmktBvalDealsUploadRequest parameters
    );

    @WebResult(name = "retrieveGetAllQuotesResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveGetAllQuotesResponse")
    public RetrieveGetAllQuotesResponse retrieveGetAllQuotesResponse(
        @WebParam(partName = "parameters", name = "retrieveGetAllQuotesRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveGetAllQuotesRequest parameters
    );

    @WebResult(name = "retrieveGetCompanyResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveGetCompanyResponse")
    public RetrieveGetCompanyResponse retrieveGetCompanyResponse(
        @WebParam(partName = "parameters", name = "retrieveGetCompanyRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveGetCompanyRequest parameters
    );

    @WebResult(name = "submitGetFundamentalsResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitGetFundamentalsRequest")
    public SubmitGetFundamentalsResponse submitGetFundamentalsRequest(
        @WebParam(partName = "parameters", name = "submitGetFundamentalsRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitGetFundamentalsRequest parameters
    );

    @WebResult(name = "retrieveOtcbvalUploadResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveOtcbvalUploadResponse")
    public RetrieveOtcbvalUploadResponse retrieveOtcbvalUploadResponse(
        @WebParam(partName = "parameters", name = "retrieveOtcbvalUploadRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveOtcbvalUploadRequest parameters
    );

    @WebResult(name = "submitScheduledResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitScheduledRequest")
    public SubmitScheduledResponse submitScheduledRequest(
        @WebParam(partName = "parameters", name = "submitScheduledRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitScheduledRequest parameters
    );

    @WebResult(name = "retrieveOtcBvalDealsUploadResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveOtcBvalDealsUploadResponse")
    public RetrieveOtcBvalDealsUploadResponse retrieveOtcBvalDealsUploadResponse(
        @WebParam(partName = "parameters", name = "retrieveOtcBvalDealsUploadRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveOtcBvalDealsUploadRequest parameters
    );

    @WebResult(name = "getCorrectionsResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "getCorrections")
    public GetCorrectionsResponse getCorrections(
        @WebParam(partName = "parameters", name = "getCorrectionsRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        GetCorrectionsRequest parameters
    );

    @WebResult(name = "submitOtcBvalDealsUploadResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitOtcBvalDealsUploadRequest")
    public SubmitOtcBvalDealsUploadResponse submitOtcBvalDealsUploadRequest(
        @WebParam(partName = "parameters", name = "submitOtcBvalDealsUploadRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitOtcBvalDealsUploadRequest parameters
    );

    @WebResult(name = "submitOtcbvalUploadResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitOtcbvalUploadRequest")
    public SubmitOtcbvalUploadResponse submitOtcbvalUploadRequest(
        @WebParam(partName = "parameters", name = "submitOtcbvalUploadRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitOtcbvalUploadRequest parameters
    );

    @WebResult(name = "submitGetDataResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitGetDataRequest")
    public SubmitGetDataResponse submitGetDataRequest(
        @WebParam(partName = "parameters", name = "submitGetDataRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitGetDataRequest parameters
    );

    @WebResult(name = "getFieldsResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "getFields")
    public GetFieldsResponse getFields(
        @WebParam(partName = "parameters", name = "getFieldsRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        GetFieldsRequest parameters
    );

    @WebResult(name = "retrieveGetFundamentalsResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveGetFundamentalsResponse")
    public RetrieveGetFundamentalsResponse retrieveGetFundamentalsResponse(
        @WebParam(partName = "parameters", name = "retrieveGetFundamentalsRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveGetFundamentalsRequest parameters
    );

    @WebResult(name = "retrieveGetDataResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveGetDataResponse")
    public RetrieveGetDataResponse retrieveGetDataResponse(
        @WebParam(partName = "parameters", name = "retrieveGetDataRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveGetDataRequest parameters
    );

    @WebResult(name = "submitGetHistoryResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitGetHistoryRequest")
    public SubmitGetHistoryResponse submitGetHistoryRequest(
        @WebParam(partName = "parameters", name = "submitGetHistoryRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitGetHistoryRequest parameters
    );

    @WebResult(name = "retrieveGetHistoryResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveGetHistoryResponse")
    public RetrieveGetHistoryResponse retrieveGetHistoryResponse(
        @WebParam(partName = "parameters", name = "retrieveGetHistoryRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveGetHistoryRequest parameters
    );

    @WebResult(name = "getPortfolioValidationResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "getPortfolioValidation")
    public GetPortfolioValidationResponse getPortfolioValidation(
        @WebParam(partName = "parameters", name = "getPortfolioValidationRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        GetPortfolioValidationRequest parameters
    );

    @WebResult(name = "submitMmktBvalDealsUploadResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitMmktBvalDealsUploadRequest")
    public SubmitMmktBvalDealsUploadResponse submitMmktBvalDealsUploadRequest(
        @WebParam(partName = "parameters", name = "submitMmktBvalDealsUploadRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitMmktBvalDealsUploadRequest parameters
    );

    @WebResult(name = "submitGetActionsResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "submitGetActionsRequest")
    public SubmitGetActionsResponse submitGetActionsRequest(
        @WebParam(partName = "parameters", name = "submitGetActionsRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        SubmitGetActionsRequest parameters
    );

    @WebResult(name = "retrieveGetActionsResponse", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001", partName = "result")
    @WebMethod(action = "retrieveGetActionsResponse")
    public RetrieveGetActionsResponse retrieveGetActionsResponse(
        @WebParam(partName = "parameters", name = "retrieveGetActionsRequest", targetNamespace = "http://services.bloomberg.com/datalicense/dlws/ps/20071001")
        RetrieveGetActionsRequest parameters
    );
}
