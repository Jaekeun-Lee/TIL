package dp;

import dp.aop.AopBrowser;
import dp.proxy.Browser;
import dp.proxy.BrowserProxy;
import dp.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

        /*
        // 직접 접근
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        //프록시 활용
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        */

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser browser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        browser.show();
        System.out.println("loading time : " + end.get());

        browser.show();
        System.out.println("loading time : " + end.get());
    }
}
