package top.lbing.down_regioncode ;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

  public static FileWriter writer;

  static {
    try {
      writer = new FileWriter("d:/1.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }  }

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
          // System.out.println(td1.childNode(0) + " " + td2.childNode(0) + " " + pcode);
          String code = td1.childNode(0).toString();
          writer.append(code + "\t" + td2.childNode(0) + "\t" + "NULL" + "\t" + pcode + "\r\n");
          writer.flush();
          String _url = url + page;
          _url = _url.substring(0, _url.lastIndexOf("/") + 1);
          String _page = td1.attr("href");
          getValue(_url, _page, code);
        } else if (null != tds && tds.size() == 2 && tds.get(0).getElementsByTag("a").size() == 0
            && tds.get(0).getElementsByTag("a").size() == 0) {
          Element td1 = tds.get(0);
          Element td2 = tds.get(1);
          if (!(td1.childNode(0) + "").equals("统计用区划代码")) {
            // System.out.println(td1.childNode(0) + " " + td2.childNode(0) + " " + pcode);
            writer.append(td1.childNode(0) + "\t" + td2.childNode(0) + "\t" + "NULL" + "\t" + pcode + "\r\n");
            writer.flush();
          }
        } else if (null != tds && tds.size() == 3) {
          Element td1 = tds.get(0);
          Element td2 = tds.get(1);
          Element td3 = tds.get(2);
          if (!(td1.childNode(0) + "").equals("统计用区划代码")) {
            // System.out.println(td1.childNode(0) + " " + (null == td3.childNode(0) ? null
            // : td3.childNode(0)) + " "
            // + td2.childNode(0) + " " + pcode);
            writer.append(td1.childNode(0) + "\t" + (null == td3.childNode(0) ? null : td3.childNode(0)) + "\t"
                + td2.childNode(0) + "\t" + pcode + "\r\n");
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
      getValue(url, page, pcode);
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
        String code = a.attr("href").replace(".html", "");
        // System.out.println(code + " " + a.childNode(0) + " " + "000000000000" +
        // "\r\n");
        writer.append(code + "\t" + a.childNode(0) + "\t" + "NULL" + "\t" + "000000000000" + "\r\n");
        String _page = a.attr("href");
        getValue(parent, _page, code);
      }
    }
  }
}
