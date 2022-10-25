
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {
    static String s;

    @Override
    public String getBotUsername() {
        return "Varzesh3MatchAlerts_bot";
    }

    @Override
    public String getBotToken() {
        return "5606102846:AAHVW5gr34VqylKGm4S63UVBMEVtQUGAJQ0";
    }

    @Override
    public void onUpdateReceived(Update update) {
            Document doc = null;
            try {
                doc = Jsoup.connect("http://varzesh3.com").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements div = doc.select("#67");
            for (Element e : div) {
                s = e.wholeText().replaceAll("( )", " ");
                s = s.replaceAll("(  )+", "");
                System.out.println(s);
            }
                SendMessage ad = new SendMessage();
                ad.setChatId(update.getMessage().getChatId().toString());
                ad.setText(s);
                try {
                    execute(ad);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
          SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(s);
            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }



}
