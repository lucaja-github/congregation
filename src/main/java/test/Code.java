package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

public class Code extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String an = arg0.getParameter("an");
		String phone = arg0.getParameter("phone");		
		if("yes".equals(an)){
			code(phone);
		}
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
