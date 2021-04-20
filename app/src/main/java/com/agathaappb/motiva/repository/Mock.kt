package com.agathaappb.motiva.repository

import com.agathaappb.motiva.infra.MotivaConstantes
import java.util.*

data class Frases(val descricao : String , val categoria : Int)

fun Int.random(): Int {
    return Random().nextInt(this)
}

class Mock {

    private val ALL = MotivaConstantes.FILTROFRASE.ALL
    private val SMILE = MotivaConstantes.FILTROFRASE.SMILE
    private val SUN = MotivaConstantes.FILTROFRASE.SUN

    private val mListasFrases : List<Frases> = listOf(
            Frases("Não sabendo que era impossível, foi lá e fez.", SMILE),
            Frases("Você não é derrotado quando perde, você é derrotado quando desiste!", SMILE),
            Frases("Quando está mais escuro, vemos mais estrelas!", SMILE),
            Frases("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", SMILE),
            Frases("Não pare quando estiver cansado, pare quando tiver terminado.", SMILE),
            Frases("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", SMILE),
            Frases("A melhor maneira de prever o futuro é inventá-lo.", SUN),
            Frases("Fracasso é o condimento que dá sabor ao sucesso.", SUN),
            Frases("Enquanto não estivermos comprometidos, haverá hesitação!", SUN),
            Frases("Se você não sabe onde quer ir, qualquer caminho serve.", SUN),
            Frases("Se você acredita, faz toda  a diferença.", SUN),
            Frases("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUN)
    )

    fun getFrases(categoriaId : Int) : String {

        val filtered = mListasFrases.filter { (it.categoria == categoriaId || categoriaId == ALL)}

        val rand = Random() . nextInt(filtered.size)

        return filtered[rand].descricao
    }

}