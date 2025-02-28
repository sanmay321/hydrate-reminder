package com.hydratereminder.command.total;

import com.hydratereminder.HydrateReminderPlugin;
import com.hydratereminder.chat.ChatMessageSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TotalCommandHandlerTest {

    @Mock
    private ChatMessageSender chatMessageSender;
    @Mock
    private HydrateReminderPlugin hydrateReminderPlugin;
    @InjectMocks
    private TotalCommandHandler totalCommandHandler;

    @Test
    public void shouldSendHydrateWithSingularBreak() {
        when(hydrateReminderPlugin.getCurrentSessionHydrationBreaks()).thenReturn(1);
        totalCommandHandler.handle();

        final String expected = "Current session: 1 hydration break.";
        verify(hydrateReminderPlugin,times(1)).getCurrentSessionHydrationBreaks();
        verify(chatMessageSender,times(1)).sendHydrateEmojiChatGameMessage(expected);
    }

    @Test
    public void shouldSendHydrateWithPluralBreak() {
        when(hydrateReminderPlugin.getCurrentSessionHydrationBreaks()).thenReturn(2);
        totalCommandHandler.handle();

        final String expected = "Current session: 2 hydration breaks.";
        verify(hydrateReminderPlugin,times(1)).getCurrentSessionHydrationBreaks();
        verify(chatMessageSender,times(1)).sendHydrateEmojiChatGameMessage(expected);
    }
}
