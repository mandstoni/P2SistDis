package controller;

import constant.Constant;
import model.Produto;
import model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProdutoService;
import service.VendaService;

import java.util.List;
import java.util.Optional;

@RestController
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;
    //COMO IMPORTA O ID DO PRODUTO AQUI....

    @PostMapping(Constant.API_VENDA)
    public void save(@RequestBody Venda venda){
        Optional<Produto> produto = (produtoService.findById(venda.getProduto().get_id()));
        venda.setProduto(venda.getProduto());
        vendaService.sendVendaRabbit(venda);
    }

    @GetMapping(Constant.API_VENDA)
    public List<Venda> findAll(){
        return vendaService.findAll();
    }

    @PutMapping(Constant.API_VENDA)
    public void update (@RequestBody Venda venda){
        Optional<Produto> produto = (produtoService.findById(venda.getProduto().get_id()));
        venda.setProduto(venda.getProduto());
        vendaService.save(venda);
    }

    @DeleteMapping(Constant.API_VENDA + "/{id}")
    public void delete(@PathVariable("id") String id){
        vendaService.delete(id);
    }

    @GetMapping(Constant.API_VENDA + "/{id}")
    public Optional<Venda> findById(@PathVariable("id") String id){
        return vendaService.findById(id);
    }
}
