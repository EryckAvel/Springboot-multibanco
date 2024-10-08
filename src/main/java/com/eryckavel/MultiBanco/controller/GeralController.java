package com.eryckavel.MultiBanco.controller;

import com.eryckavel.MultiBanco.model.Geral;
import com.eryckavel.MultiBanco.service.GeralSerivce;
import com.eryckavel.MultiBanco.utils.ControllerUtils;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geral")
public class GeralController extends ControllerUtils {

    @Autowired
    private GeralSerivce serivce;

//    @GetMapping("/{rota}")
//    public ResponseEntity<List<Geral>> listarGeralRota(@PathVariable("rota") String rota){
//        gerarConexaoViaRota(rota);
//        return serivce.listar();
//    }

    @GetMapping
    public ResponseEntity<List<Geral>> listarGeralHeadre(){
        return serivce.listar();
    }


}
