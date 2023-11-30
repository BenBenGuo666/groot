package groot.springboot.demo.zalo;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.springframework.http.HttpHeaders;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 10:30
 * @description:
 */
public class ZaloDemo {

    public static void main(String[] args) {

        String host = "https://jr.chat.zalo.me";
        String path = "/jr/userinfo";
        String cookie = "zoaw_sek=KHSF.1625572110.0.rI7whf2npVkUyYcRaB7D-v2npVkGiStxaGIgKFJEpVi; zoaw_type=0; _zlang=vn; zpsid=wKB-.380567639.1.NkqMZNIJATaZauRFU9CfsG7WM-fCenplGwKQuDq5ujFaTkz2TPv3SX2JATa; zpw_sek=v9fI.380567639.a0.fWwQ4oDQVWnqMj4Q0bf-35Xu6sS1O5mwK3CFT4eIALjW7KPy6ZypIsGGC4HYPqCkNlFenodAcyguMsfcY3xhQW; __zi=3000.SSZzejyD0jydXQckra00a3BBfxQL71AQV8UaljXL5vLwWQlrtr0MqNA2f_hVKXRMC0.1; __zi-legacy=3000.SSZzejyD0jydXQckra00a3BBfxQL71AQV8UaljXL5vLwWQlrtr0MqNA2f_hVKXRMC0.1; ozi=2000.SSZzejyD0jydXQckra00a3BBfxQK71AQVOUbij1I49XpWgsqr1aPddZ6fRVO5XcSD30m.1; app.event.zalo.me=7747454918499156493";
        HttpRequest httpRequest = HttpRequest.get(host + path);
        httpRequest.header(HttpHeaders.COOKIE, cookie);
        httpRequest.header(HttpHeaders.REFERER, "https://chat.zalo.me/");
        HttpCookie httpCookie = new HttpCookie("zlogin_session", "kW4JGLyjCnIxFnDDLXTbH-Ti2KzU56XCw6aGNW5KPbIZA0HT3LHbNQCh0LuDLsLCVG");
        httpCookie.setDomain(".id.zalo.me");
        HttpCookie httpCookie2 = new HttpCookie("zpdid", "4XN_dLVmg3iN4f2KLF_FCnGUa9zI-yKq");
        httpCookie2.setDomain(".id.zalo.me");
        HttpCookie httpCookie3 = new HttpCookie("zpuid", "15cdcb4155a944e1b2b8");
        httpCookie3.setDomain(".id.zalo.me");
        HttpCookie httpCookie4 = new HttpCookie("zoaw_sek", "KHSF.1625572110.0.rI7whf2npVkUyYcRaB7D-v2npVkGiStxaGIgKFJEpVi");
        httpCookie4.setDomain(".zalo.me");
        HttpCookie httpCookie5 = new HttpCookie("zoaw_type", "0");
        httpCookie5.setDomain(".zalo.me");
        HttpCookie httpCookie6 = new HttpCookie("_zlang", "vn");
        httpCookie6.setDomain(".zalo.me");
        HttpCookie httpCookie7 = new HttpCookie("zpsid", "wKB-.380567639.1.NkqMZNIJATaZauRFU9CfsG7WM-fCenplGwKQuDq5ujFaTkz2TPv3SX2JATa");
        httpCookie7.setDomain(".zalo.me");
        HttpCookie httpCookie8 = new HttpCookie("zpw_sek", "v9fI.380567639.a0.fWwQ4oDQVWnqMj4Q0bf-35Xu6sS1O5mwK3CFT4eIALjW7KPy6ZypIsGGC4HYPqCkNlFenodAcyguMsfcY3xhQW");
        httpCookie8.setDomain(".chat.zalo.me");
        HttpCookie httpCookie9 = new HttpCookie("__zi", "3000.SSZzejyD0jydXQckra00a3BBfxQL71AQV8UaljXL5vLwWQlrtr0MqNA2f_hVKXRMC0.1");
        httpCookie9.setDomain(".zalo.me");
        HttpCookie httpCookie10 = new HttpCookie("__zi-legacy", "3000.SSZzejyD0jydXQckra00a3BBfxQL71AQV8UaljXL5vLwWQlrtr0MqNA2f_hVKXRMC0.1");
        httpCookie10.setDomain(".zalo.me");
        HttpCookie httpCookie11 = new HttpCookie("ozi", "2000.SSZzejyD0jydXQckra00a3BBfxQK71AQVOUbij1I49XpWgsqr1aPddZ6fRVO5XcSD30m.1");
        httpCookie11.setDomain(".zalo.me");
        HttpCookie httpCookie12 = new HttpCookie("app.event.zalo.me", "7747454918499156493");
        httpCookie12.setDomain(".zalo.me");
        List<HttpCookie> cookies = new ArrayList<>();
        cookies.add(httpCookie);
        cookies.add(httpCookie2);
        cookies.add(httpCookie3);
        cookies.add(httpCookie4);
        cookies.add(httpCookie5);
        cookies.add(httpCookie6);
        cookies.add(httpCookie7);
        cookies.add(httpCookie8);
        cookies.add(httpCookie9);
        cookies.add(httpCookie10);
        cookies.add(httpCookie11);
        cookies.add(httpCookie12);
        httpRequest.cookie(cookies);
        System.out.println(httpRequest);
        HttpResponse httpResponse = httpRequest.execute();
        System.out.println(httpResponse);


        String params = "ghcKhtZhhG/BG+xrupOI3ODFidzgCaYVwdrJbxS45WtQyBAOV+LtQvyavrxPEeZpHWUHLG2ppBC2A2A3KdTHpqnsfHwMc6qgxAWdADXveEw=";
        System.out.println(Base64Decoder.decode(params));
    }

}
