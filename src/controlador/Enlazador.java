/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import fev1.dif.afip.gov.ar.ArrayOfFECAEDetRequest;
import fev1.dif.afip.gov.ar.FEAuthRequest;
import fev1.dif.afip.gov.ar.FECAECabRequest;
import fev1.dif.afip.gov.ar.FECAEDetRequest;
import fev1.dif.afip.gov.ar.FECAERequest;
import fev1.dif.afip.gov.ar.FECAEResponse;
import fev1.dif.afip.gov.ar.FERecuperaLastCbteResponse;
import fev1.dif.afip.gov.ar.Service;
import modelo.Cliente;
import modelo.Venta;
import org.datacontract.schemas._2004._07.sge_service_contracts.Autorizacion;
import service.contracts.service.istp1.LoginService;

/**
 *
 * @author usuario
 */
public class Enlazador {
    public static Object [] autorizarComprobante(int ptoVta, int cbteTipo, String codGrupo, Venta v, String montId, double montCotz, int cantReg, Cliente cliente, int concepto){
        
        Autorizacion aut = new Autorizacion();
        FEAuthRequest feauthRequest = new FEAuthRequest();
        FERecuperaLastCbteResponse recuperaUltimoComprobante = new FERecuperaLastCbteResponse();
        FECAERequest feCAEReq = new FECAERequest();
        FECAEResponse fecaeResponse = new FECAEResponse();
        Object [] resultado = new Object[2];
        String estado;
        
        aut = solicitarComprobante(codGrupo);
        feauthRequest = generarFEAuthRequest(aut);
        recuperaUltimoComprobante = solicitarFECompUltimoAut(feauthRequest, ptoVta, cbteTipo); 
        long ultimoComprobante = recuperaUltimoComprobante.getCbteNro();
        feCAEReq = generarFECAERequest(ptoVta, cantReg, cbteTipo, montId, montCotz, v, cliente, concepto, ultimoComprobante);
        fecaeResponse = solicitarFECAE(feauthRequest, feCAEReq);
        estado = obtenerEstado(fecaeResponse);
        
        resultado [0] = estado;
        resultado [1] = ultimoComprobante+1;
        return resultado;
    }
    
    public static Autorizacion solicitarComprobante(String codGrupo){
        Autorizacion aut = new Autorizacion();
        LoginService cliente = new LoginService();
        aut = cliente.getSGEAuthService().solicitarAutorizacion(codGrupo);        
        return aut;
    }
 
    public static FEAuthRequest generarFEAuthRequest(Autorizacion aut){
        FEAuthRequest feauthRequest = new FEAuthRequest();
        feauthRequest.setCuit(aut.getCuit());
        feauthRequest.setSign(aut.getSign().getValue());
        feauthRequest.setToken(aut.getToken().getValue());
        return feauthRequest;
    }

    private static FERecuperaLastCbteResponse solicitarFECompUltimoAut(FEAuthRequest feauthRequest, int ptoVta, int cbteTipo) {
        FERecuperaLastCbteResponse ultimoCompAut = new FERecuperaLastCbteResponse();
        Service servicio = new Service();
        ultimoCompAut = servicio.getServiceSoap().feCompUltimoAutorizado(feauthRequest, ptoVta, cbteTipo);
        return ultimoCompAut;
    }

    private static FECAERequest generarFECAERequest(int ptoVta, int cantReg, int cbteTipo, String montId, double montCotz, Venta v, Cliente cliente, int concepto, long ultimoComprobante) {
        FECAERequest feCAEReq = new FECAERequest();
        
            FECAECabRequest feCAECabReq = new FECAECabRequest();
            feCAECabReq.setCantReg(cantReg);
            feCAECabReq.setCbteTipo(cbteTipo);
            feCAECabReq.setPtoVta(ptoVta);
            
            FECAEDetRequest feDetReq = new FECAEDetRequest();
            feDetReq.setConcepto(concepto);
            feDetReq.setDocNro(cliente.getDocNro());
            feDetReq.setDocTipo(96);
            long algo = ultimoComprobante + 1;
            feDetReq.setCbteDesde(algo);
            feDetReq.setCbteHasta(algo);
            feDetReq.setCbteFch(v.getFecha());
            feDetReq.setImpTotal(v.getTotal());
            feDetReq.setImpTotConc(0.0);
            feDetReq.setImpNeto(v.getTotal());
            feDetReq.setImpIVA(0.0);
            feDetReq.setMonId(montId);
            feDetReq.setMonCotiz(montCotz);           
            ArrayOfFECAEDetRequest arrayOfFECAEDetRequest = new ArrayOfFECAEDetRequest();
            arrayOfFECAEDetRequest.getFECAEDetRequest().add(feDetReq);
        
        feCAEReq.setFeCabReq(feCAECabReq);
        feCAEReq.setFeDetReq(arrayOfFECAEDetRequest);
        
        return feCAEReq;
    }

    private static FECAEResponse solicitarFECAE(FEAuthRequest auth, FECAERequest feCAEReq) {
        FECAEResponse fecaeResponse = new FECAEResponse();
        Service servicio = new Service();
        fecaeResponse = servicio.getServiceSoap().fecaeSolicitar(auth, feCAEReq);
        return fecaeResponse;
    }

    private static String obtenerEstado(FECAEResponse fecaeResponse) {
        String estado = "";
        estado = fecaeResponse.getFeDetResp().getFECAEDetResponse().get(0).getResultado();
        return estado;
    }
    
}
