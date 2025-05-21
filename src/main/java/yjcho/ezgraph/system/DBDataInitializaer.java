package yjcho.ezgraph.system;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yjcho.ezgraph.app.content.*;
import yjcho.ezgraph.app.dataset.DataSet;
import yjcho.ezgraph.app.dataset.DataSetRepository;
import yjcho.ezgraph.app.user.AppUser;
import yjcho.ezgraph.app.user.AppUserService;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class DBDataInitializaer implements CommandLineRunner {

    private final DataSetRepository dataSetRepository;

    private final UserContentRepository userContentRepository;
    private final GuestContentRepository guestContentRepository;

    private final AppUserService appUserService;

    @Override
    public void run(String... args) throws Exception {
        AppUser u1 = new AppUser();
        u1.setUsername("user1");
        u1.setPassword("pwd1");
        u1.setDateCreated(LocalDateTime.now());
        AppUser u2 = new AppUser();
        u2.setUsername("user2");
        u2.setPassword("pwd2");
        u2.setDateCreated(LocalDateTime.now());
        u1 = appUserService.save(u1);
        u2 = appUserService.save(u2);

        DataSet ds1 = new DataSet();
        ds1.setDataSet("data1");
        DataSet ds2 = new DataSet();
        ds2.setDataSet("data1");
        System.out.println(ds2.getId());
        dataSetRepository.save(ds1);
        dataSetRepository.save(ds2);

        UserContent uc1 = new UserContent();
        uc1.setTitle("uc1 title");
        uc1.setDateCreated(LocalDateTime.now());
        uc1.setLastUpdated(LocalDateTime.now());
        uc1.setType(ContentType.TEMPLATE);
        uc1.setTemplate("uc1 template");
        uc1.setUser(u1);
        UserContent uc2 = new UserContent();
        uc2.setTitle("uc2 title");
        uc2.setDateCreated(LocalDateTime.now());
        uc2.setLastUpdated(LocalDateTime.now());
        uc2.setType(ContentType.GRAPH);
        uc2.setTemplate("uc2 template");
        uc2.setDataSet(ds1);
        uc2.setUser(u2);
        userContentRepository.save(uc1);
        userContentRepository.save(uc2);

        GuestContent gc1 = new GuestContent();
        gc1.setTitle("gc1 title");
        gc1.setDateCreated(LocalDateTime.now());
        gc1.setValidUntil(LocalDateTime.now().plusDays(7));
        gc1.setType(ContentType.TEMPLATE);
        gc1.setTemplate("gc1 template");
        gc1.setShareKey("key1");
        gc1.setPassword("pwd1");
        GuestContent gc2 = new GuestContent();
        gc2.setTitle("gc2 title");
        gc2.setDateCreated(LocalDateTime.now());
        gc2.setValidUntil(LocalDateTime.now().plusDays(7));
        gc2.setType(ContentType.GRAPH);
        gc2.setDataSet(ds2);
        gc2.setTemplate("gc2 template");
        gc2.setShareKey("key2");
        gc2.setPassword("pwd2");
        guestContentRepository.save(gc1);
        guestContentRepository.save(gc2);
    }
}
