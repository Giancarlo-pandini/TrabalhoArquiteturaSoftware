/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Giancarlo
 */
@WebService(serviceName = "EmprestimoWebService")
public class EmprestimoWebService {

    /**
     * This is a sample web service operation
     */    
    @WebMethod(operationName = "ValidaEmprestimo")
    public boolean ValidaEmprestimo(@WebParam(name = "ValorEmprestimo") double ValorEmprestimo, @WebParam(name = "Salario") double Salario, @WebParam(name = "QtdParcelas") int QtdParcelas) {
        double VlrParcela = ValorEmprestimo / QtdParcelas;
        double TrintaPorcentoSalario = 0.3 * Salario;
        return (VlrParcela <= TrintaPorcentoSalario);
    }
}
