package pack.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ZipcodeDto {
	private String zipcode, area1, area2, area3, area4;
}
