package com.gmail.rotoyutoriapp

object Romaji {

  //3字
  private val threeOn = Map(
    "kya" -> "きゃ","kyu" -> "きゅ","kyo" -> "きょ",
    "sya" -> "しゃ","syu" -> "しゅ","syo" -> "しょ",
    "sha" -> "しゃ","shu" -> "しゅ","sho" -> "しょ",
    "tya" -> "ちゃ","tyu" -> "ちゅ","tyo" -> "ちょ",
    "cha" -> "ちゃ","chu" -> "ちゅ","cho" -> "ちょ",
    "nya" -> "にゃ","nyu" -> "にゅ","nyo" -> "にょ",
    "hya" -> "ひゃ","hyu" -> "ひゅ","hyo" -> "ひょ",
    "mya" -> "みゃ","myu" -> "みゅ","myo" -> "みょ",
    "rya" -> "りゃ","ryu" -> "りゅ","ryo" -> "りょ",
    "gya" -> "ぎゃ","gyu" -> "ぎゅ","gyo" -> "ぎょ",
    "zya" -> "じゃ","zyu" -> "じゅ","zyo" -> "じょ",
    "bya" -> "びゃ","byu" -> "びゅ","byo" -> "びょ",
    "pya" -> "ぴゃ","pyu" -> "ぴゅ","pyo" -> "ぴょ",
    "shi" -> "し","chi" -> "ち","tsu" -> "つ",
    "hwa" -> "ふぁ","hwi" -> "ふぃ","hwe" -> "ふぇ","hwo" -> "ふぉ"
  )

  //2字
  private val twoOn = Map(
    "ka" -> "か","ki" -> "き","ku" -> "く","ke" -> "け","ko" -> "こ",
    "sa" -> "さ","si" -> "し","su" -> "す","se" -> "せ","so" -> "そ",
    "ta" -> "た","ti" -> "ち","tu" -> "つ","te" -> "て","to" -> "と",
    "na" -> "な","ni" -> "に","nu" -> "ぬ","ne" -> "ね","no" -> "の",
    "ha" -> "は","hi" -> "ひ","hu" -> "ふ","he" -> "へ","ho" -> "ほ",
    "ma" -> "ま","mi" -> "み","mu" -> "む","me" -> "め","mo" -> "も",
    "ya" -> "や","yu" -> "ゆ","yo" -> "よ",
    "ra" -> "ら","ri" -> "り","ru" -> "る","re" -> "れ","ro" -> "ろ",
    "wa" -> "わ","wo" -> "を","nn" -> "ん",
    "ga" -> "が","gi" -> "ぎ","gu" -> "ぐ","ge" -> "げ","go" -> "ご",
    "za" -> "ざ","zi" -> "じ","zu" -> "ず","ze" -> "ぜ","zo" -> "ぞ",
    "da" -> "だ","di" -> "ぢ","du" -> "づ","de" -> "で","do" -> "ど",
    "ba" -> "ば","bi" -> "び","bu" -> "ぶ","be" -> "べ","bo" -> "ぼ",
    "pa" -> "ぱ","pi" -> "ぴ","pu" -> "ぷ","pe" -> "ぺ","po" -> "ぽ",
    "ja" -> "じゃ","ju" -> "じゅ","jo" -> "じょ",
    "fa" -> "ふぁ","fi" -> "ふぃ","fu" -> "ふ","fe" -> "ふぇ" -> "fo" -> "ふぉ"
  )

  //a,i,u,e,o
  private val aiueo = Map(
    "a" -> "あ","i" -> "い","u" -> "う","e" -> "え","o" -> "お"
  )

  def romajiToHiragana(romaji: String): String = {
    var savedHiragana = ""
    var tmpHiragana = ""
    romaji.foreach(c => {
      //全角が含まれている場合はnullを返す
      if (c.toString.getBytes().length >= 2) return null
      tmpHiragana += c
      val length = tmpHiragana.length
      if (length == 3 && !threeOn.contains(tmpHiragana)) {
        savedHiragana += tmpHiragana(0)
        tmpHiragana = tmpHiragana.drop(1)
      } else if (length == 3 && threeOn.contains(tmpHiragana)) {
        savedHiragana += threeOn(tmpHiragana)
        tmpHiragana = ""
      } else if (length == 2 && !twoOn.contains(tmpHiragana) && tmpHiragana(0) == tmpHiragana(1)) {
        savedHiragana += "っ"
        tmpHiragana = tmpHiragana.drop(1)
      } else if (length == 2 && !twoOn.contains(tmpHiragana) && tmpHiragana(0) == 'n' && !aiueo.contains(tmpHiragana(1).toString)) {
        savedHiragana += "ん"
        tmpHiragana = tmpHiragana.drop(1)
      } else if (length == 2 && twoOn.contains(tmpHiragana)) {
        savedHiragana += twoOn(tmpHiragana)
        tmpHiragana = ""
      } else if (length == 1 && aiueo.contains(tmpHiragana)) {
        savedHiragana += aiueo(tmpHiragana)
        tmpHiragana = ""
      } else if (length == 1 && !"[a-z]+".r.matches(tmpHiragana)) {
        //記号だった場合
        savedHiragana += tmpHiragana(0)
        tmpHiragana = tmpHiragana.drop(1)
      }
    })
    savedHiragana
  }


}
