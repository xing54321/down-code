/*package top.lbing.down1;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

*//**
 * Hello world!
 *
 *//*
public class Jsoup2 {

  public static FileWriter writer;

  static {
    try {
      writer = new FileWriter("/1.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void getValue(String url, String page, String pcode) {
    try {
      Document doc = Jsoup.parse(new URL(url + page).openStream(), "GBK", "");
      Element table = doc.body().getElementsByTag("table").get(4);
      Elements trs = table.getElementsByTag("tr");
      for (Element tr : trs) {
        Elements tds = tr.getElementsByTag("td");
        if (null != tds && tds.size() == 2 && tds.get(0).getElementsByTag("a").size() == 1
            && tds.get(0).getElementsByTag("a").size() == 1) {
          Element td1 = tds.get(0).getElementsByTag("a").get(0);
          Element td2 = tds.get(1).getElementsByTag("a").get(0);
          // System.out.println(td1.childNode(0) + " " + td2.childNode(0));
          writer.append(td1.childNode(0) + "    " + td2.childNode(0) + "    " + pcode + "\r\n");
          writer.flush();
          String _url = url + page;
          _url = _url.substring(0, _url.lastIndexOf("/") + 1);
          String _page = td1.attr("href");
          getValue(_url, _page, td1.childNode(0).toString());
        } else if (null != tds && tds.size() == 2 && tds.get(0).getElementsByTag("a").size() == 0
            && tds.get(0).getElementsByTag("a").size() == 0) {
          Element td1 = tds.get(0);
          Element td2 = tds.get(1);
          if (!(td1.childNode(0) + "").equals("统计用区划代码")) {
            // System.out.println(td1.childNode(0) + " " + td2.childNode(0));
            writer.append(td1.childNode(0) + "    " + td2.childNode(0) + "\r\n");
            writer.flush();
          }
        } else if (null != tds && tds.size() == 3) {
          Element td1 = tds.get(0);
          Element td2 = tds.get(1);
          Element td3 = tds.get(2);
          if (!(td1.childNode(0) + "").equals("统计用区划代码")) {
            // System.out.println(td1.childNode(0) + " " + td3.childNode(0) + " " +
            // td2.childNode(0));
            writer.append(td1.childNode(0) + "    " + td3.childNode(0) + "    " + td2.childNode(0) + "\r\n");
            writer.flush();
          }
        }
      }
    } catch (Exception e) {
      try {
        Thread.sleep(50L);
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
      getValue(url, page, td1.childNode(0).to);
    }
  }

  // public static void main1(String[] args) {
  // String _url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2016/37/";
  // String _page = "3714.html";
  // try {
  // getValue(_url, _page);
  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }

  public static void main(String[] args) throws Exception {
    String parent = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/";
    Document doc = Jsoup.parse(new URL(parent).openStream(), "GBK", "");
    Element table = doc.body().getElementsByTag("table").get(4);
    Elements tds = table.getElementsByTag("td");
    // System.out.println(tds);
    for (Element e : tds) {
      Elements as = e.getElementsByTag("a");
      // System.out.println(as);
      for (Element a : as) {
        System.out.println(a.attr("href").replace(".html", "") + " " + a.childNode(0) + "000000000000");
        // writer.append(a.attr("href").replace(".html", "") + " " + a.childNode(0) +
        // "\r\n");
        String _url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/";
        String _page = a.attr("href");
        getValue(_url, _page, "");
      }
    }
  }
}
*/