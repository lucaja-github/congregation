package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String codes = ""; 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String press = request.getParameter("press");
		String phone = request.getParameter("phone");		
		if(press.equals("yes")){
			codes = code(phone);
		}
	}
	
	public static String getCodes() {
		return codes;
	}
	
	public String code(String phone) {
		// 短信应用SDK AppID
		int appid = 1400143107; // 1400开头

		// 短信应用SDK AppKey
		String appkey = "6b58f94132771fa59b9d40b26e446062";

		// 需要发送短信的手机号码
		String[] phoneNumbers = {phone};

		// 短信模板ID，需要在短信应用中申请
		int templateId = 196423; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
		//templateId7839对应的内容是"您的验证码是: {1}"
		// 签名
		String smsSign = "众味集"; 


		String random = "";
		try {			
			for(int i=0;i<4;i++){
				int ii = (int)(Math.random()*10);
				random += ii+"";
			}

			String[] params = {random,"2"};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
			SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
					templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
			System.out.println(result);
		} catch (HTTPException e) {
			// HTTP响应码错误
			e.printStackTrace();
		} catch (JSONException e) {
			// json解析错误
			e.printStackTrace();
		} catch (IOException e) {
			// 网络IO错误
			e.printStackTrace();
		}
		return random;
	}
}


