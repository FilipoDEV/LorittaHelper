package net.perfectdreams.loritta.helper.serverresponses.portuguese

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.perfectdreams.loritta.api.messages.LorittaReply
import net.perfectdreams.loritta.helper.serverresponses.RegExResponse
import net.perfectdreams.loritta.helper.utils.Constants
import net.perfectdreams.loritta.helper.utils.Emotes
import java.util.regex.Pattern

/**
 * Response when people don`t know how to solve
 * a problem and need help with anything, telling them to mention the support
 */
class HelpMeResponse : RegExResponse() {
    override val priority: Int
        get() = -1000

    init {
        patterns.add("algu?(e|é)?m|como|ninguém".toPattern(Pattern.CASE_INSENSITIVE))
        patterns.add("ajud|d(ú|u)vida|help|faç|fass|coloco".toPattern(Pattern.CASE_INSENSITIVE))
        patterns.add("\\?".toPattern(Pattern.CASE_INSENSITIVE))
    }

    override fun getResponse(event: GuildMessageReceivedEvent, message: String) =
            if (!message.contains(Constants.PORTUGUESE_LORITTA_SUPPORT_ROLE_ID.toString())) {
                listOf(
                        LorittaReply(
                                "Psiu! Se você está com uma dúvida, escreva a sua dúvida no chat e marque o cargo do <@&${Constants.PORTUGUESE_LORITTA_SUPPORT_ROLE_ID}>!",
                                Emotes.LORI_PAT
                        ),
                        LorittaReply(
                                "Mas lembre-se que editar a mensagem marcando o cargo não fará os Suportes receberem a notificação para te ajudar!",
                                Emotes.LORI_COFFEE
                        )
                )
            } else listOf()
}
