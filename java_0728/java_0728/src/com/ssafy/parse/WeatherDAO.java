package com.ssafy.parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//파싱한 데이터를 가져오는 클래스
public class WeatherDAO {

	private List<Weather> list = new ArrayList<Weather>();
	
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private Document doc;//DOM에서 문서를 분석한 결과는 document객체로 표현
	private Element root;

	private Weather weather;
	
	//싱글톤 패턴 적용으로 인해 내부에서 객체 생성
	private static WeatherDAO weatherDAO = new WeatherDAO();
	
	private WeatherDAO() {	}
	
	//생성한 객체 제공을 위한 getter
	public static WeatherDAO getWeatherDAO() {
		return weatherDAO;
	}


	private void connectXML(String url) throws ParserConfigurationException, SAXException, IOException {
		//인스턴스 초기화 작업
		builder = factory.newDocumentBuilder();
		
		//URL에서 해당하는 XML 문서 파싱하여 그 결과를 doc 인스턴스에 저장
		//Dom Object 저장되어 있음
		doc = builder.parse(url);
		
		//DOM Tree의 루트노트 가져오기
		// 최 상위 element
		root = doc.getDocumentElement();
		
		parse(root);
		//byTagName(root);
	}
	
	//url에서 weather 정보를 가져와서 List에 저장하는 메서드
	public List<Weather> getWeatherList(String url){
		try {
			connectXML(url);
		}catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 ELEMENT_NODE(요소 노드) = 1
	 TEXT_NODE(텍스트 노드) = 3 -> 줄바꿈과 공백등을 포함한 HTML 문서내의 텍스트
	 */
	//파싱
	public void parse(Node node) {
		//자식 노드들 가져오기
		NodeList n1 = node.getChildNodes();
		int length = n1.getLength();
		
		//자식들만큼 돌면서 확인하기
		for(int i = 0; i < length; i++) {
			Node child = n1.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = child.getNodeName();
				
				//data라는 이름을 가진 element node 찾기
				if(nodeName.equals("data")) {
					weather = new Weather();
				}
				//재귀로 아래 자식 노드 찾아 들어가기
				parse(child);
				
			}else if(child.getNodeType() == Node.TEXT_NODE && child.getNodeValue().trim().length() != 0) {
				//텍스트 노드 중에 부모 노드를 파악하여 감싸여 있는 태그 파악
				if(child.getParentNode().getNodeName().equals("hour")) {
					weather.setHour(Integer.valueOf(child.getNodeValue()));
				}else if(child.getParentNode().getNodeName().equals("temp")) {
					weather.setTemp(Double.valueOf(child.getNodeValue()));
				}else if(child.getParentNode().getNodeName().equals("wfKor")) {
					weather.setWfKor(child.getNodeValue());
				}else if(child.getParentNode().getNodeName().equals("reh")) {
					weather.setReh(Integer.valueOf(child.getNodeValue()));
					list.add(weather);
				}
			}
		}
	}
	
	public void byTagName(Element element) {
		NodeList n1 = element.getElementsByTagName("data");
				
		for(int i = 0; i < n1.getLength(); i++) {
			Node data = n1.item(i);
			weather = new Weather();
			NodeList childs = data.getChildNodes();
			
			for(int j = 0; j < childs.getLength(); j++) {
				Node child = childs.item(j);
				String nodeName = child.getNodeName();
				if(nodeName.equals("hour")) {
					weather.setHour(Integer.valueOf(child.getTextContent()));
				}else if(nodeName.equals("temp")) {
					weather.setTemp(Double.valueOf(child.getTextContent()));
				}else if(nodeName.equals("wfKor")) {
					weather.setWfKor(child.getTextContent());
				}else if(nodeName.equals("reh")) {
					weather.setReh(Integer.valueOf(child.getTextContent()));
				}
			}
		}
		list.add(weather);
	}
	
	
}
