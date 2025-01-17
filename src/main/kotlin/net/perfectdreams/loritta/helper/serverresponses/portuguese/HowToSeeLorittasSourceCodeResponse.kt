package net.perfectdreams.loritta.helper.serverresponses.portuguese

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.perfectdreams.loritta.api.messages.LorittaReply
import net.perfectdreams.loritta.helper.serverresponses.RegExResponse
import net.perfectdreams.loritta.helper.utils.Emotes
import java.util.regex.Pattern

class HowToSeeLorittasSourceCodeResponse : RegExResponse()  {
    init {
        patterns.add("como|onde|cad(ê|e)".toPattern(Pattern.CASE_INSENSITIVE))
        patterns.add("v(ê|e|er)|est(a|á)".toPattern(Pattern.CASE_INSENSITIVE))
        patterns.add("c(o|ó)digo(-| )fonte".toPattern(Pattern.CASE_INSENSITIVE))
        patterns.add("lori|lorri|loritta|lorrita".toPattern(Pattern.CASE_INSENSITIVE))
    }

    override fun getResponse(event: GuildMessageReceivedEvent, message: String): List<LorittaReply> =
        listOf(
                LorittaReply(
                        "Você pode ver meu código fonte aqui: https://bit.ly/lorittagit",
                        Emotes.LORI_PAT
                )
        )
}