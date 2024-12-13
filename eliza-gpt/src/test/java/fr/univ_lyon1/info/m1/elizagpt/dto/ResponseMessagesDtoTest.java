package fr.univ_lyon1.info.m1.elizagpt.dto;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Tests for ResponseMessagesDto.
 */
public class ResponseMessagesDtoTest {
    /**
     * Test the message processor.
     */
    @Test
    public void testResponseMessagesDto() {
        ResponseMessagesDto responseMessagesDto = new ResponseMessagesDto();
        assertThat(responseMessagesDto.getResponseDto(), is(notNullValue()));
    }
}
