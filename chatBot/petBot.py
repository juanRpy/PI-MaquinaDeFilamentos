import telebot

bot = telebot.TeleBot("6231150170:AAHII5endnvpDu0sH70dX4cHsUrY4iq_0E8")
@bot.message_handler(commands = ["help", "start"])

def enviar (message):
    bot.reply_to(message, "Bienvenido, soy P.E.T")

bot.polling()