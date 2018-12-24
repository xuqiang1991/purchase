package com.purchase.weixin.handler;

import com.purchase.weixin.builder.TextBuilder;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

 // @Autowired
  private WxMpService wxMpService;

  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                  Map<String, Object> context, WxMpService xxx,
                                  WxSessionManager sessionManager) {

    if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
      //TODO 可以选择将消息保存到本地
    }
    //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
    return new TextBuilder().build("你好", wxMessage,wxMpService);
  }

}
