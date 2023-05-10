import telebot
from confing import *

bot = telebot.TeleBot(TELEGRAM_TOKEN)

@bot.message_handler(commands = ["help", "start"])
def enviar (message):
    bot.reply_to(message, "Bienvenido, soy el PetBot")


@bot.message_handler(content_types=["text"])
def mensaje_texto(message):
    if message.text.startswith("/"):
        bot.send_message(message.chat.id, "Comando no disponible")
    else:
        bot.send_message(message.chat.id, "¿Que se le ofrece?")


if __name__ == "__main__":
    print('Iniciando el bot')
    bot.infinity_polling()
    print('Fin')