-------------------------------------------------------------게시판용
create sequence seq_board ;--자동 번호 생성

create table tbl_board(

 bno number(10,0),
 title nvarchar2(200) not null,
 content nvarchar2(2000) not null,
 writer nvarchar2(50) not null,
 regidate date default sysdate,
 updatedate date default sysdate
 
); --board 테이블 생성

alter table tbl_board add constraint pk_board primary key(bno);
--tbl_board 테이블에 규약 이름으로 pk_board를 명명하고 bno를 기본키로 설정

insert into tbl_board (bno, title , content , writer) 
	values (seq_board.nextval , '테스트 제목' , '테스트 내용' , 'user00');
	
select /*+ index_desc(tbl_board pk_board)*/ * from tbl_board where bno>0; --실행계획

select * from tbl_board order by bno desc; --bno를 기준으로 내림차순 정렬

select /*+ FULL(tbl_board) */ rownum rn, bno, title from tbl_board where bno > 0 order by bno;

 	select bno ,title content, writer, regidate, updatedate
 	
 	from(
 	
 	select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn , bno, title, content , writer,
 				 regidate, updatedate from tbl_board 
 				 					  where rownum <=20 
 	) where rn > 10;
 	
  	
insert into TBL_BOARD(bno,title,content,writer) values(60,'댓글용제목' , '댓글용내용' , 'kje');


 ---------------------------------------------------------
 ------------------------------------------------------------댓글용
 --board객체의 (bno 60~70 사용)
 
select * from tbl_reply order by rno desc;

create table tbl_reply(

	rno number(10,0),
	bno number(10,0) not null,
	reply varchar2(1000) not null, 
	replyer varchar2(50) not null,
	replyDate date default sysdate,
	updateDate date default sysdate
	
	);

 	create sequence seq_reply; 
 	
 	alter table tbl_reply add constraint pk_reply primary key(rno);
 	alter table tbl_reply add constraint fk_reply_board foreign key (bno) references tbl_board(bno);
 	
 	select * from TBL_REPLY;



alter table tbl_board add (replycnt number default 0);
update tbl_board set replycnt = (select count(rno) from tbl_reply where TBL_REPLY.bno = tbl_board.bno);