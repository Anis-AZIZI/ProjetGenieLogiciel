package fr.univ_lyon1.info.m1.elizagpt.dao;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests for MessagesDao.
 */
public class MessageDaoTest {
    /**
     * Test the messageDao.
     */
    @Test
    public void testMessageDao() {
        MessageDao messageDao = new MessageDao();
        assertThat(messageDao.getLastMessage(), is("Bonjour"));

    }
}
