package top.sharehome.share_study_rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消息队列向区块链传输数据启动类
 * @author AntonyCheng
 */
@SpringBootApplication
public class ShareStudyRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareStudyRabbitmqApplication.class, args);
    }

}
