package controller;

import constant.Constant;
import model.Estoque;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EstoqueService;
import service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ProdutoService produtoService;
    //COMO IMPORTA O ID DO PRODUTO AQUI....

    @PostMapping(Constant.API_ESTOQUE)
    public void save(@RequestBody Estoque estoque){
        Optional<Produto> produto = (produtoService.findById(estoque.getProduto().get_id()));
        estoque.setProduto(estoque.getProduto());
        estoqueService.sendEstoqueRabbit(estoque);
    }

    @GetMapping(Constant.API_ESTOQUE)
    public List<Estoque> findAll(){
        return estoqueService.findAll();
    }

    @PutMapping(Constant.API_ESTOQUE)
    public void update (@RequestBody Estoque estoque){
        Optional<Produto> produto = (produtoService.findById(estoque.getProduto().get_id()));
        estoque.setProduto(estoque.getProduto());
        estoqueService.save(estoque);
    }

    @DeleteMapping(Constant.API_ESTOQUE + "/{id}")
    public void delete(@PathVariable("id") String id){
        estoqueService.delete(id);
    }

    @GetMapping(Constant.API_ESTOQUE + "/{id}")
    public Optional<Estoque> findById(@PathVariable("id") String id){
        return estoqueService.findById(id);
    }
}
