package service;

import model.Produto;
import model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbit.ProdutoProducer;
import repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoProducer produtoProducer;

    public void sendProdutoRabbit(Produto produto){
        produtoProducer.send(produto);
    }


    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public void save(Produto produto){
        produtoRepository.save(produto);
    }

    public Optional<Produto> findById(String id){
        return produtoRepository.findById(id);
    }

    public void delete(String id){
        produtoRepository.deleteById(id);
    }
}
