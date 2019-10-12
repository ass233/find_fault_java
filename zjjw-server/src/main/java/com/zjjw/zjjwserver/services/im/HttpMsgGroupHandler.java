package com.zjjw.zjjwserver.services.im;

import com.zjjw.zjjwserver.cache.UserSessionCache;
import com.zjjw.zjjwserver.po.GroupToUser;
import com.zjjw.zjjwserver.server.command.InnerCommand;
import com.zjjw.zjjwserver.server.command.InnerCommandContext;
import com.zjjw.zjjwserver.services.GroupToUserService;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Function:
 *
 * @author frozen
 * Date: 2018/12/26 11:15
 * @since JDK 1.8
 */
@Service
@Slf4j
public  class HttpMsgGroupHandler extends AbstractMsgHandler{
	@Autowired
	GroupToUserService groupToUserService;
    @Override
    public String sendMsg(String userId, String receiverId, String msg) {
        try {
	        GroupToUser groupToUser =new GroupToUser();
	        groupToUser.setGroupId(Long.valueOf(receiverId));
	        List<GroupToUser> list = groupToUserService.list(groupToUser);
	        if(CollectionUtils.isEmpty(list)){
		        return receiverId+"群不在";
	        }
	        for(GroupToUser group:list) {
	        	String receiverUser = String.valueOf(group.getUserId());
		        NioSocketChannel socketChannel = UserSessionCache.get(receiverUser);
		        if (null == socketChannel) {
			        log.error("receiverUser={}不在线", receiverUser);
			        return receiverUser + "不在线";
		        }
		        socketChannel.writeAndFlush(new TextWebSocketFrame(msg));
		        ChannelFuture future = socketChannel.writeAndFlush(msg);
		        future.addListener((ChannelFutureListener) channelFuture ->
				        log.info("群消息给={}，发送={}，成功！",receiverUser, msg));
	        }
            return null;
        }catch (Exception e){
            return "发送消息失败";
        }
    }

}
