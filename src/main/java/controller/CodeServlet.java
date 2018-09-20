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
		// ����Ӧ��SDK AppID
		int appid = 1400143107; // 1400��ͷ

		// ����Ӧ��SDK AppKey
		String appkey = "6b58f94132771fa59b9d40b26e446062";

		// ��Ҫ���Ͷ��ŵ��ֻ�����
		String[] phoneNumbers = {phone};

		// ����ģ��ID����Ҫ�ڶ���Ӧ��������
		int templateId = 196423; // NOTE: �����ģ��ID`7839`ֻ��һ��ʾ������ʵ��ģ��ID��Ҫ�ڶ��ſ���̨������
		//templateId7839��Ӧ��������"������֤����: {1}"
		// ǩ��
		String smsSign = "��ζ��"; 


		String random = "";
		try {			
			for(int i=0;i<4;i++){
				int ii = (int)(Math.random()*10);
				random += ii+"";
			}

			String[] params = {random,"2"};//��������Ԫ�ظ�����ģ���б�����������һ�£�����������templateId:5678��Ӧһ������������������Ԫ�ظ���Ҳ������һ��
			SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
					templateId, params, smsSign, "", "");  // ǩ������δ�ṩ����Ϊ��ʱ����ʹ��Ĭ��ǩ�����Ͷ���
			System.out.println(result);
		} catch (HTTPException e) {
			// HTTP��Ӧ�����
			e.printStackTrace();
		} catch (JSONException e) {
			// json��������
			e.printStackTrace();
		} catch (IOException e) {
			// ����IO����
			e.printStackTrace();
		}
		return random;
	}
}


