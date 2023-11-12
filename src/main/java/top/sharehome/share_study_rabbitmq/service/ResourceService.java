package top.sharehome.share_study_rabbitmq.service;

import com.alibaba.fastjson2.JSONObject;
import top.sharehome.share_study_rabbitmq.utils.FabricGatewayUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.hyperledger.fabric.client.Contract;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

/**
 * MQ 教学资料监听者
 *
 * @author AntonyCheng
 */
@Component
@Slf4j
public class ResourceService {
    @Resource
    FabricGatewayUtil fabricGatewayUtil;

    public static final String RESOURCE_QUEUE = "resourceQueue";

    @RabbitHandler
    @RabbitListener(queues = ResourceService.RESOURCE_QUEUE)
    public void resourceMQ1(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String operate = (String) rabbitResult.get("operate");
            HashMap<String, Object> object = (HashMap<String, Object>) rabbitResult.get("object");
            String method = (String) rabbitResult.get("method");
            try {
                Contract contract = fabricGatewayUtil.getContract();
                contract.newProposal(method)
                        .addArguments(
                                String.valueOf(object.get("id")),
                                operate,
                                String.valueOf(object.get("belong")),
                                String.valueOf(object.get("name")),
                                String.valueOf(object.get("info")),
                                String.valueOf(object.get("url")),
                                String.valueOf(object.get("score")),
                                String.valueOf(object.get("status")),
                                String.valueOf(object.get("createTime")),
                                String.valueOf(object.get("updateTime")),
                                String.valueOf(object.get("isDeleted")))
                        .build()
                        .endorse()
                        .submitAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = ResourceService.RESOURCE_QUEUE)
    public void resourceMQ2(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String operate = (String) rabbitResult.get("operate");
            HashMap<String, Object> object = (HashMap<String, Object>) rabbitResult.get("object");
            String method = (String) rabbitResult.get("method");
            try {
                Contract contract = fabricGatewayUtil.getContract();
                contract.newProposal(method)
                        .addArguments(
                                String.valueOf(object.get("id")),
                                operate,
                                String.valueOf(object.get("belong")),
                                String.valueOf(object.get("name")),
                                String.valueOf(object.get("info")),
                                String.valueOf(object.get("url")),
                                String.valueOf(object.get("score")),
                                String.valueOf(object.get("status")),
                                String.valueOf(object.get("createTime")),
                                String.valueOf(object.get("updateTime")),
                                String.valueOf(object.get("isDeleted")))
                        .build()
                        .endorse()
                        .submitAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = ResourceService.RESOURCE_QUEUE)
    public void resourceMQ3(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String operate = (String) rabbitResult.get("operate");
            HashMap<String, Object> object = (HashMap<String, Object>) rabbitResult.get("object");
            String method = (String) rabbitResult.get("method");
            try {
                Contract contract = fabricGatewayUtil.getContract();
                contract.newProposal(method)
                        .addArguments(
                                String.valueOf(object.get("id")),
                                operate,
                                String.valueOf(object.get("belong")),
                                String.valueOf(object.get("name")),
                                String.valueOf(object.get("info")),
                                String.valueOf(object.get("url")),
                                String.valueOf(object.get("score")),
                                String.valueOf(object.get("status")),
                                String.valueOf(object.get("createTime")),
                                String.valueOf(object.get("updateTime")),
                                String.valueOf(object.get("isDeleted")))
                        .build()
                        .endorse()
                        .submitAsync();
            } catch (Exception e) {
                deliveryTag = message.getMessageProperties().getDeliveryTag();
                channel.basicAck(deliveryTag, true);
                e.printStackTrace();
            }
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = ResourceService.RESOURCE_QUEUE)
    public void resourceMQ4(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String operate = (String) rabbitResult.get("operate");
            HashMap<String, Object> object = (HashMap<String, Object>) rabbitResult.get("object");
            String method = (String) rabbitResult.get("method");
            try {
                Contract contract = fabricGatewayUtil.getContract();
                contract.newProposal(method)
                        .addArguments(
                                String.valueOf(object.get("id")),
                                operate,
                                String.valueOf(object.get("belong")),
                                String.valueOf(object.get("name")),
                                String.valueOf(object.get("info")),
                                String.valueOf(object.get("url")),
                                String.valueOf(object.get("score")),
                                String.valueOf(object.get("status")),
                                String.valueOf(object.get("createTime")),
                                String.valueOf(object.get("updateTime")),
                                String.valueOf(object.get("isDeleted")))
                        .build()
                        .endorse()
                        .submitAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = ResourceService.RESOURCE_QUEUE)
    public void resourceMQ5(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String operate = (String) rabbitResult.get("operate");
            HashMap<String, Object> object = (HashMap<String, Object>) rabbitResult.get("object");
            String method = (String) rabbitResult.get("method");
            try {
                Contract contract = fabricGatewayUtil.getContract();
                contract.newProposal(method)
                        .addArguments(
                                String.valueOf(object.get("id")),
                                operate,
                                String.valueOf(object.get("belong")),
                                String.valueOf(object.get("name")),
                                String.valueOf(object.get("info")),
                                String.valueOf(object.get("url")),
                                String.valueOf(object.get("score")),
                                String.valueOf(object.get("status")),
                                String.valueOf(object.get("createTime")),
                                String.valueOf(object.get("updateTime")),
                                String.valueOf(object.get("isDeleted")))
                        .build()
                        .endorse()
                        .submitAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}