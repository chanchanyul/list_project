package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz1 {
    public static void main(String[] args) {

        List<Campaign> originList = new ArrayList<>();
        originList.add(new Campaign(true, "광고1"));
        originList.add(new Campaign(true, "광고2"));
        originList.add(new Campaign(true, "광고3"));
        originList.add(new Campaign(true, "광고4"));
        originList.add(new Campaign(true, "광고5"));
        originList.add(new Campaign(true, "광고6"));
        originList.add(new Campaign(true, "광고7"));
        originList.add(new Campaign(true, "광고8"));
        originList.add(new Campaign(false, "컨텐츠1"));
        originList.add(new Campaign(false, "컨텐츠2"));
        originList.add(new Campaign(false, "컨텐츠3"));
        originList.add(new Campaign(false, "컨텐츠4"));
        originList.add(new Campaign(false, "컨텐츠5"));

        printList(originList);

        List<Campaign> sortedList = sortByRatio(originList, 2, 1);

        printList(sortedList);
    }

    private static void printList(List<Campaign> sortedList) {
        System.out.println("------------printList-------------");
        System.out.println(sortedList);
        System.out.println("----------------------------------");
    }


    /**
     * 정렬되지 않은 캠페인 리스트와 광고, 컨텐츠의 비율을 입력받아서, 비율데로 정렬된 리스트를 반환.
     *
     * @param originList   정렬되지 않은 캠페인 리스트
     * @param adRatio      광고 비율
     * @param contentRatio 컨텐츠 비율
     * @return adRatio : contentRatio 비율로 정렬된 리스트
     */
    private static List<Campaign> sortByRatio(List<Campaign> originList, int adRatio, int contentRatio) {
        int listLength = originList.size();
        int sumRatio = adRatio + contentRatio;


        // ad, content 별도 배열로 추출하여 각각 셔플
        List<Campaign> adsList = new ArrayList<>();
        List<Campaign> contentsList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            if (originList.get(i).isAd == true) {
                adsList.add(originList.get(i));
            } else {
                contentsList.add(originList.get(i));
            }
        }

        Collections.shuffle(adsList);
        Collections.shuffle(contentsList);


        // Head 로 캠페인 랜덤 추출
        // Head.isAd; true/false 에 따라 sumRatio 나누는 수 정의
        // sumRatio, 나누는 값에 따라 true/false 로 이루어진 배열 생성
        Random rand = new Random();
        int n = rand.nextInt(listLength) + 1;

        Boolean[] booleanArray = new Boolean[listLength];

        if (originList.get(n).isAd == true) {
            for (int i = 0; i < listLength; i++) {
                if (i % sumRatio < adRatio) {
                    booleanArray[i] = true;
                } else {
                    booleanArray[i] = false;
                }
            }
        } else {
            for (int i = 0; i < listLength; i++) {
                if (i % sumRatio < contentRatio) {
                    booleanArray[i] = false;
                } else {
                    booleanArray[i] = true;
                }
            }
        }


        // booleanArray 돌면서 true/false 에 따라 각 리스트에서 존재여부 체크 후 추출
        ArrayList resultList = new ArrayList();
        int adsIndex = 0;
        int contentsIndex = 0;
        for (int i = 0; i < listLength; i++) {
            if (booleanArray[i] == true) {
                if (adsIndex < adsList.size()) {
                    resultList.add(adsList.get(adsIndex));
                    adsIndex++;
                } else {
                    if (contentsIndex < contentsList.size()) {
                        resultList.add(contentsList.get(contentsIndex));
                        contentsIndex++;
                    } else {
                        break;
                    }

                }
            } else {
                if (contentsIndex < contentsList.size()) {
                    resultList.add(contentsList.get(contentsIndex));
                    contentsIndex++;
                } else {
                    if (adsIndex < adsList.size()) {
                        resultList.add(adsList.get(adsIndex));
                        adsIndex++;
                    } else {
                        break;
                    }

                }
            }
        }
        System.out.println("Ad : Content = " + adRatio + " : " + contentRatio);
        return resultList;
    }
}

class Campaign {
    boolean isAd;
    String title;

    public Campaign(boolean isAd, String title) {
        this.isAd = isAd;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "isAd=" + isAd +
                ", title='" + title + '\'' +
                '}';
    }
}