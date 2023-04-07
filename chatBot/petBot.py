import telebot
from confing import *

bot = telebot.TeleBot(TELEGRAM_TOKEN)
@bot.message_handler(commands = ["help", "start"])

def enviar (message):
    bot.reply_to(message, "Bienvenido, soy P.E.T")

bot.polling()