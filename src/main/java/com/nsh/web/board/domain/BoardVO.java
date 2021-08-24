package com.nsh.web.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardVO {
	public int bid;

	public String cate_cd;

	public String title;

	public String content;

	public String tag;

	public int view_cnt;

	public String reg_id;

	public String reg_dt;

	public String edit_dt;

}
