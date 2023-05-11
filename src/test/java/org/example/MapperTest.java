package org.example;

import org.example.dao.DiscussPostMapper;
import org.example.dao.LoginTicketMapper;
import org.example.dao.MessageMapper;
import org.example.dao.UserMapper;
import org.example.entity.DiscussPost;
import org.example.entity.LoginTicket;
import org.example.entity.Message;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectPost() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

    @Test
    public void testUser() {
        System.out.println(userMapper.selectById(1));
    }

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testTicket(){
//        LoginTicket loginTicket = new LoginTicket();
//        loginTicket.setUserId(101);
//        loginTicket.setTicket("abc");
//        loginTicket.setStatus(0);
//        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
//        System.out.println(loginTicketMapper.insertLoginTicket(loginTicket));


//        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
//        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc", 1);


    }

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void MessageTest() {
        List<Message> messages = messageMapper.selectConversations(111, 0, 20);
        for (Message message : messages) {
            System.out.println(message);
        }

        List<Message> list = messageMapper.selectLetters("111_112", 0, 10);
        for (Message message : list) {
            System.out.println(message);
        }

        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);

        count = messageMapper.selectLetterCount("111_112");
        System.out.println(count);

        count = messageMapper.selectLetterUnreadCount(131, "111_131");
        System.out.println(count);
    }

}
