package rabbit;

import model.Venda;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import service.VendaService;

@Component
public class VendaConsumer {

    @Autowired
    private VendaService vendaService;

    @RabbitListener(queues = {"${queue.venda.name}"})
    public void receive (@Payload Venda venda){
        System.out.println("Id: "+ venda.get_id() + "\nDescricao: "
                + "\nData: " + venda.getDate() + "\nProduto: " + venda.getProduto().getNome());
        vendaService.save(venda);
    }
}