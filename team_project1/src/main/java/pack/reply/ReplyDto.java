package pack.reply;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ReplyDto {
	private int reply_no, reply_book_no, reply_point, reply_like_cnt, 
	reply_del_is, reply_blocked, reply_blocked_cnt, reply_gnum, reply_onum;
	
	private String reply_id, reply_cont, reply_create_date, 
	reply_ip, reply_del_date, reply_title, reply_image; 


}
