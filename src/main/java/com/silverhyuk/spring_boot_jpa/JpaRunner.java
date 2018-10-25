package com.silverhyuk.spring_boot_jpa;

import com.silverhyuk.spring_boot_jpa.account.Account;
import com.silverhyuk.spring_boot_jpa.study.Study;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; //jpa 핵심 클래스


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("Silverhyuk");
        account.setPassword("password");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);



        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }
}
