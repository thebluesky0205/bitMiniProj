package com.example.demo.service;

import com.example.demo.entity.Weather;
import com.example.demo.repository.WeatherRepository;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Lazy
@Log
public class WeatherCrawlService {
    @Autowired
    WeatherRepository weatherRepository;

    private org.jsoup.nodes.Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    public List<Weather> weatherFindAll() {
        log.info("weahterFindAll()");

        return weatherRepository.findAll();
    }

    public void mainCrawler() {
        log.info("mainCrawler(): ");

        document = connectUrl("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EC%84%9C%EC%9A%B8+%EB%82%A0%EC%94%A8&oquery=%EC%84%9C%EC%9A%B8+%EA%B5%AC%EB%B3%84+%EB%82%A0%EC%94%A8&tqi=U0K3Lwp0J1ssssgWgLossssssbG-474199");
        weatherRepository.deleteAll();

        weatherGo(document.select("li.date_info.today"));

        weatherGo(document.select("div.info_area"));
    }

    public void weatherGo(Elements elements) {
        log.info("weatherGO(): elements - " + elements);

        Weather weather = null;

        for (int i = 0; i < elements.size() - 1; i++) {
            log.info("weatherGO");
            weather = new Weather();

            weather.setWeatherNo(String.valueOf(weatherRepository.findAll().size() + 1));
            weather.setDday(elements.get(i).select("span.day_info>span").text());

            weather.setMimg(elements.get(i).select("span.point_time.morning>span.ico_state2.ws1").attr("src"));
            weather.setMrr(elements.get(i).select("span.point_time.morning>span.rain_rate>span.num").text());

            weather.setAimg(elements.get(i).select("span.point_time.afternoon>span").attr("src"));
            weather.setArr(elements.get(i).select("span.point_time.afternoon>span.rain_rate>span.num").text());

            weather.setTemp(elements.get(i).select("dl>dd").text());

            weatherRepository.save(weather);
        }
    }
}
