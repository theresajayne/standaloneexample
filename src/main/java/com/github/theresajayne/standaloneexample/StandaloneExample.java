package com.github.theresajayne.standaloneexample;

import com.github.theresajayne.standaloneexample.model.beans.StandaloneVO;
import com.github.theresajayne.standaloneexample.model.dao.StandaloneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class StandaloneExample {

    @Autowired
    private StandaloneDao standaloneDao;

    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        StandaloneExample standalone = ctx.getBean(StandaloneExample.class);
        standalone.startStandalone();
    }

    private void startStandalone() {
        StandaloneVO standaloneVO = new StandaloneVO();
        standaloneVO.setName("Test1");
        standaloneVO.setAmount(239.32);
        standaloneVO.setCreated(new Date());
        standaloneDao.save(standaloneVO);
        List<StandaloneVO> result = standaloneDao.findAll();
        for(StandaloneVO vo : result)
        {
            System.out.println(vo.getId()+":"+vo.getName()+":"+vo.getAmount()+":"+vo.getCreated());
        }

    }
}
