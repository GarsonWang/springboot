package com.example.demo;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by 69404 on 2019/2/23.
 */
public class CyclicBarrierTest {
    private int num;

    public CyclicBarrierTest(int num) {
        this.num = num;
    }

    public synchronized void  await() throws InterruptedException {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setVfs(SpringBootVFS.class);


        ConcurrentHashMap hashMap = new ConcurrentHashMap();


        num--;
        if ( num == 0 ) {
            notifyAll();
        } else {
            while(num != 0) {
                wait();
            }
        }
    }
}
