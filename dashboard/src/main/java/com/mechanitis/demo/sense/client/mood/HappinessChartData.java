package com.mechanitis.demo.sense.client.mood;

import com.mechanitis.demo.sense.infrastructure.MessageListener;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class HappinessChartData {
    private final XYChart.Series<String, Double> dataSeries = new XYChart.Series<>();
    private final Map<Integer, Integer> minuteToDataPosition = new HashMap<>();

    public HappinessChartData() {
        // TODO: get minute value for right now
        int nowMinute = LocalDateTime.now().getMinute();

        // TODO: create an empty bar for every minute for the next ten minutes
        IntStream.range(nowMinute, nowMinute + 10)
                 .forEach(this::initialiseBarToZero);


        HashSet<Mood> payload = new HashSet<>(Arrays.asList(Mood.HAPPY));

    }

    public XYChart.Series<String, Double> getDataSeries() {
        return dataSeries;
    }

    private void someMethod(HashSet<Mood> payload) {
        onMessage(Optional.of(new Message(payload)));
    }

    void onMessage(Optional<Message> message) {
        message.ifPresent(tweetMood -> {
            // do something
        });
    }

    private void initialiseBarToZero(int minute) {
        dataSeries.getData().add(new Data<>(String.valueOf(minute), 0.0));
        minuteToDataPosition.put(minute, dataSeries.getData().size() - 1);

        IntStream.range(1, 5)
                 .parallel()
                 .forEach(this::doSomething);
    }

    private void doSomething(int anInt) {

    }

}

