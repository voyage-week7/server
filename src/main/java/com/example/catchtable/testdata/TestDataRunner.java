package com.example.catchtable.testdata;

import com.example.catchtable.dto.RestApi;
import com.example.catchtable.dto.StoreImageDto;
import com.example.catchtable.dto.store.StoreResponseDto;
import com.example.catchtable.model.Store;
import com.example.catchtable.model.StoreImageURL;
import com.example.catchtable.repository.StoreImageRepository;
import com.example.catchtable.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Component
public class TestDataRunner implements ApplicationRunner {

    @Autowired
    StoreResponseDto storeResponseDto;

    @Autowired
    StoreImageDto storeImageDto;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreImageRepository storeImageRepository;


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        // 스토어 테스트용 데이터 생성
        createTestData
                ("스시미야비","오미카세","서울특별시 마포구 포은로2가길 62 합정글로벌센터","7만원","12만원",
                        "02-332-1990","미야비의 두 번째 매장, 정갈하고 섬세한 스시 오마카세",
                        126.91108052226465f,37.54999355951708f);
        createTestData
                ("스시사랑","오미카세","서울특별시 서초구 반포대로26길 10 진흥펠리체","4만원","9만원",
                        "02-525-2672","훌륭한 가성비를 자랑하는 서초역 스시 오마카세",
                        127.00997317797584f,37.490024320192006f);
        createTestData
                ("스시이세이 동탄롯데점","오마카세","경기도 화성시 동탄역 160, 롯데백화점 스트리트몰 2층","3 - 6만원","8.8만원",
                        "031-8036-3639","스시오마카세 카운터석 예약이 가능합니다. 룸 예약은 전화로 부탁드립니다. (031-8036-3639) 런치1-2부, 디너 1-2부로 운영하고 있습니다.",
                        127.09809263250708f,37.19972413146425f);
        createTestData
                ("스시노아야","오마카세","경기도 화성시 동탄역 160, 롯데백화점 스트리트몰 2층","12.5만원","23.5만원",
                        "02-792-8260","나인원한남 만족스러운 하이엔드 스시야",
                        127.00447485534929f,37.53619436002874f);
        createTestData
                ("스시킨","오마카세","서울특별시 강남구 선릉로161길 6","3 - 20만원","15 - 20만원",
                        "02-518-2057","숙성된 자연산 사시미와 스시를 즐길 수 있는 곳",
                        127.03992941420591f,37.52709659198974f);
        createTestData
                ("심야식당 쿤","오마카세","경기도 성남시 분당구 정자일로 121 더샵스타파크","4.5 - 6.5만원","9 - 10만원",
                        "031-717-6972","정자동 만족스러운 미들급 스시 오마카세",
                        127.10507689804608f,37.360341916405574f);
        createTestData
                ("스시만월","오마카세","전라남도 순천시 왕지1길 3-26","4만원","9만원",
                        "061-725-7792","전남 순천 호수공원 근처 스시 오마카세 맛집",
                        127.52286922107982f,34.97115105191506f);

        createTestData
                ("우마카세쿤","우마카세","경기도 성남시 분당구 정자일로 135 정자동3차 푸르지오 시티","영업안함","13.5만원",
                        "031-718-6972","장자동 맛집 한우 오마카세 전문점",
                        127.10560213798844f,37.362605278708806f);
        createTestData
                ("소성정","우마카세","인청광역시 연수구 센트럴로 194 더샵센트럴파크2 A동 135호 1층","영업안함","4 - 15만원",
                        "032-858-9744","기념일에 방문하기 좋은 송도 프리미엄 한우 오마카세",
                        126.6506598715694f,37.397578170271416f);
        createTestData
                ("수린","우마카세","서울특별시 강남구 언주로164길 24 아크로스 빌딩","영업안함","18만원",
                        "02-515-9220","정갈한 프리미엄 한우 아마카세 전문점",
                        127.03548257828085f,37.52539286528746f);
        createTestData
                ("우연","우마카세","전라북도 전주시 덕진구 세병서로 39","7 - 15만원","9 - 15만원",
                        "010-5521-3601","특별한 날 가기 좋은 에코시티 한우 오마카세 맛집",
                        127.12660116121486f,35.871986907401634f);
        createTestData
                ("이속우화 구우몽","우마카세","경기도 하남시 마사대로 750 스타필드 하남 1층","5.95만원","5.95만원",
                        "031-8072-8386","- 매월 23일 5시 일월 예약 오픈! - 콜키지 1팀당 1병 무료 추가(추가시 3만원)",
                        127.22369690761253f,37.54551063197394f);
        createTestData
                ("우화","우마카세","부산광역시 해운대구 해운대해변로 209번나길 21 삼원빌딩","영업안함","3 - 20만원",
                        "051-747-4060","다짜와 프라이빗룸이 있는 프리미엄 1++ 소고기 전문점",
                        129.15482946558535f,35.16040916875926f);
        createTestData
                ("선정생한우","우마카세","부산광역시 연제구 월드컵대로 145번길 14","2 - 6만원","2 - 6만원",
                        "051-852-2662","한우 오마카세의 원조, 오랜 전통의 한우 참숯구이 맛집",
                        129.0801114860058f,35.18577428207184f);

        createTestData
                ("파불라(PABULLA)","콜키지프리","서울특별시 강남구 도산대로81길 51 루미안빌딩 1층","3 - 8만원","4 - 10만원",
                        "02-517-2852","풍미가득 매혹적인 사천요리를 주제로 하는 모던 레스토랑",
                        127.04580657437262f,37.52714626636378f);
        createTestData
                ("한와담 가든","콜키지프리","서울특별시 중구 장충단로 170","4 - 7만원","4 - 7만원",
                        "02-2274-7905","와인과 담소가 함께하는 숙성 한우 전문점",
                        127.00594195468847f,37.559897320632324f);
        createTestData
                ("수묵당","콜키지프리","서울특별시 강남구 학동로53길 20","5.8만원","8.5만원",
                        "02-511-2962","제철 식재료 본연의 맛과 계절을 담아내는 한식 다이닝",
                        127.04000679691572f,37.51841315335242f);
        createTestData
                ("룩소(Luxor)","콜키지프리","대전광역시 서구 남산로 31","15 - 20만원","15 - 20만원",
                        "042-485-5284","누룩 숙성 스테이크를 메인으로 한 특별 코스요리 전문점",
                        127.39679439822957f,36.34621920536011f);
        createTestData
                ("마마램","콜키지프리","서울특별시 강남구 도산대로62길 11","1 - 4만원","1 - 4만원",
                        "02-543-5310","트렌디한 분위기의 청담동 프리미엄 양갈비 맛집",
                        127.0431963135942f,37.52263548113365f);
        createTestData
                ("청담동 참치명가","콜키지프리","서울특별시 강남구 도산대로 542 우산빌딩","4만원","6 - 10만원",
                        "050-71301-2598","고급스럽고 퀄리티 좋은 혼마구로 전문점",
                        127.05301402349325f,37.524606930193734f);
        createTestData
                ("바베큐쉑","콜키지프리","제주특별자치도 서귀포시 안덕면 동괄로 135","1 - 4만원","1 - 4만원",
                        "064-901-1999","진짜 텍사스 바베큐를 맛볼 수 있는 곳",
                        126.33956675054866f,33.30845437959466f);

        createTestData
                ("키친마이야르","인기레스토랑","서울특별시 강남구 언주로170길 22","2 - 5만원","2 - 5만원",
                        "없음","키친 마이야르는 음식을 중심으로 다양한 콘텐츠가 펼쳐지는 키친 & 라이브 스튜디오입니다.",
                        127.03542376233591f,37.52661148828942f);
        createTestData
                ("MAISON HANNAM","인기레스토랑","서울특별시 용산구 유엔빌리지3길 24","2 - 9만원","2 - 9만원",
                        "010-2340-1289","한남동 유엔빌리지 한강뷰가 멋진 레스토랑",
                        127.01291225104859f,37.534238567308996f);
        createTestData
                ("웨스틴조선서울 아리아","인기레스토랑","서울특별시 중구 소공로 106 웨스틴조선서울","12.5 - 15만원","13.5 - 15만원",
                        "02-317-0357","도심의 에너지와 감각이 살아있는 뷔페 레스토랑",
                        126.98004512702369f,37.5644841090277f);
        createTestData
                ("오스테리아 오르조","인기레스토랑","서울특별시 용산구 한남대로20길 47","2 - 8만원","2 - 8만원",
                        "010-6361-0801","온라인예약은 1시간 30분 간격 2인만 가능합십니다. 3인 이상, 이용시간이 더 필요하신분은 전화문의 바랍니다.",
                        127.00948415323819f,37.534898875484714f);
        createTestData
                ("바위파스타바","인기레스토랑","서울특별시 용산구 이태원로 254 지하2층","영업안함","12만원",
                        "없음","예약제로 운영되는 여덟 석 규모의 파스타 바입니다.",
                        127.00115691634598f,37.537250862241144f);

        createTestData
                ("괴르츠","뷰맛집","서울특별시 마포구 토정로 136-13","1 - 8만원","1 - 9만원",
                        "02-336-1745","멋진 한강 뷰와 함께하는 일품 코스 요리와 각종 와인",
                        126.92583383330353f,37.54487481293968f);
        createTestData
                ("라쿠치나","뷰맛집","서울특별시 용산구 회나무로44길 10 라쿠치나","2 - 15만원","2 - 15만원",
                        "02-794-6006","30년 전통의 고급스러운 남산 뷰 이탈리안 레스토랑",
                        126.99646686568478f,37.540537213201326f);
        createTestData
                ("러반로제 레스토랑","뷰맛집","서울특별시 송파구 석촌호수로 274 씨엠빌딩","2 - 8만원","1 - 8만원",
                        "070-7778-9471","석촌호수 전망 좋은 루프탑 레스토랑",
                        127.1062141146f,37.51023160481009f);
        createTestData
                ("가스트로통","뷰맛집","서울특별시 종로구 자하문로8길10","5 - 7만원","8 - 15만원",
                        "02-730-4162","서촌에서 만나는 스위스 레스토랑",
                        126.97260071712668f,37.578659774789465f);
        createTestData
                ("스톤힐","뷰맛집","서울특별시 종로구 자하문로45길 8-11","2 - 5만원","2 - 10만원",
                        "02-395-2505","뷰가 근사한 부암동 이탈리안 레스토랑",
                        126.95890838468063f,37.59883127700681f);

        // 이미지 등록
        createStoreImageURL("https://image.toast.com/aaaaaqx/catchtable/shopinfo/s21181/21181_2172915445152658.jpg",1L);
        createStoreImageURL("https://ldb-phinf.pstatic.net/20210730_144/1627580818717KcE6p_JPEG/v3nJXi_AVJFrF6yyXY7gdnRy.jpg?type=f804_408_60_sharpen",1L);
        createStoreImageURL("https://ldb-phinf.pstatic.net/20210730_144/1627580818717KcE6p_JPEG/v3nJXi_AVJFrF6yyXY7gdnRy.jpg?type=f804_408_60_sharpen",1L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/OJZpJ/btrfhbGm9kz/PQvJ2Vgo1jXxmW2LVs5F11/img.jpg",1L);
        createStoreImageURL("https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdBTGVs%2Fbtrfd0rRRR4%2FkDG4dKHJEkwSYK1wwGvmbk%2Fimg.jpg",1L);
        createStoreImageURL("https://naverbooking-phinf.pstatic.net/20181116_236/1542357923172x6cCv_JPEG/Restaurant_Murasaki_Details_6103.jpg?type=f804_408_60_sharpen",1L);

        createStoreImageURL("https://d12zq4w4guyljn.cloudfront.net/20190603101007_photo2_a70c16cb4692.jpg",2L);
        createStoreImageURL("https://humorworld.net/wp-content/uploads/3-11-1024x768.jpg",2L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA1MDNfNzkg/MDAxNjIwMDMwMjE5NDE2.pFSXunvqUBlp6Ky4ioXTXGh_IxPLTalghxUqSVskvEEg.AkTegQZNsgQHor4g1TV6BnxN6-rL2DI1w_LzIUTLf2Ig.JPEG.robotluv1226/SE-16eda59c-5753-4b34-83c0-436e9a7c1aa6.jpg?type=w800",2L);
        createStoreImageURL("https://img.siksinhot.com/place/1518150389253225.jpg",2L);
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2017/06/12/m_84317G180621_3.jpg",2L);

        createStoreImageURL("https://d12zq4w4guyljn.cloudfront.net/300_300_20220222221959_photo2_afea29ac4faa.jpg",3L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/efRVJf/btrhGbK9CsT/EEeVLSkNCjmYsUHRMUK7Wk/img.png",3L);
        createStoreImageURL("https://d12zq4w4guyljn.cloudfront.net/20220222221959_photo1_afea29ac4faa.jpg",3L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/oyk9S/btrssv7M6Ci/sbgqNr62YO5D5O1vK3GSiK/img.png",3L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/cxC0Dl/btrhFRsBHC5/gAVlXkgBIjjl2gcMXMwhf1/img.png",3L);

        createStoreImageURL("https://media-cdn.tripadvisor.com/media/photo-s/1c/2f/2b/b2/20201013-190246-largejpg.jpg",4L);
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2021/01/11/m_56033A122537_2.jpg",4L);
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2021/01/11/m_56033A122537_3.jpg",4L);
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2020/04/28/m_56033A140649_3.jpg",4L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA0MjJfMTE3/MDAxNTg3NTI0OTQwMDEx.uka1HQhJzO9ZU2YiDEJMo0bzK5wPq5kLKZ6fsB672ucg.skJSbunhEZQutIdkP5dqteS7ANfpWPNkjR_AYp0UZOgg.JPEG.sielle83/DSC09546.JPG?type=w2",4L);

        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxNzEyMjhfMTc1/MDAxNTE0NDI2MDg1OTk4.cmvehOpFyfq22dtwbJ-0_JQuLzNwZw3qv6CJrBcC21Ug.DaWFIwWrPAsL3bSVu3fG_ItMQBMTmhRZi9b7TgsI-lkg.JPEG.nokkebi/PicsArt_12-26-09.43.20.jpg?type=w800",5L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/20140827_80/yoonakim1208_1409128823976zLXuK_JPEG/NaverBlog_20140827_174018_06.jpg?type=w2",5L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/20140827_247/yoonakim1208_1409128815636ddMhp_JPEG/NaverBlog_20140827_174015_01.jpg?type=w2",5L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxNzAzMTRfMTM5/MDAxNDg5NDkzOTkwNDU3.R4_GhwXQCYxYAI2RLULnhmyRwQP5jsTffG1HiTqhDEIg.OEuRqfIuf092KQKpX0oUzv2b60oYP6AMUkk9cTxFKSEg.JPEG.yxxnii/IMG_9084.JPG?type=w800",5L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTAzMjhfMjgz/MDAxNjE2OTM1NDIzMDU0.6u9hLlFBSw7dCwe3HO6jjhKs4GcFTUxC7rXmGD9yox8g.KCp-xc3CDVb1XFi1Aa3kDkZZ_fPcdHZs_7GrZrndpngg.JPEG.cjdqksqkwl1/output_1158426780.jpg?type=w800",5L);

        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxODA1MjVfMTMy/MDAxNTI3MjMxNzIyNTA1.mU5yv6bzlOoIOcenm9zSRJ2w7vLTXFyYQN-fg17kG90g.BjOoXRl-ZpSo1VVQE4MeRbCeEuo6kXO-KCCs0VezhkYg.JPEG.symin67/2018-05-16_002.jpg?type=w2",6L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxOTExMTVfNDcg/MDAxNTczNzU5MzM5MTIy.pBR-Mgq8xM4Q3kl9Gga2yoUY6R2wsSFK_av22wVckhQg.j095xGVaY-OkRHA2czM7FqrQJ5Dj8CPHCuh78UUjTM8g.JPEG.dbwkgk/SE-6bce8036-0925-495f-87ee-4e22b830374a.jpg?type=w800",6L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxODA1MjdfMjE0/MDAxNTI3NDEwNTMzODMw.l-GWOvDqEQQdp2tieOXCpRhdV52AY4yHHRFFl3TAxpMg.IPr6-tXXNcnehVLhSS_78yRk_cpsLGXwHXCq9O9MvpYg.JPEG.symin67/2018-05-16_011.jpg?type=w2",6L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxODAzMjVfMTQz/MDAxNTIxOTY5NDY4ODc4.NEXcc1L0xnSZDHAjLvDha_TEw4KmPJ_K7F9Wk4lQ0awg.-Xped_u516Vg6xGnOKBoBzU7Yqo5vfyKjgzxqrAHBsIg.JPEG.golf_doctor/image_3621259821521969334432.jpg?type=w800",6L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxODA1MjVfMTE5/MDAxNTI3MjMxNzIzODc3.Yl57OmhjG1cm44OnyN_L40V54rHxVeUt3S-TGQIcmOwg._yBxxSZdqlv-d0OE3mKG_aHLZkOapFSPR_uKOHPmgysg.JPEG.symin67/2018-05-16_007.jpg?type=w2",6L);

        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA3MjlfMTIx/MDAxNjI3NTYzNzAxNjY2.PVsCuxUYqjM4PV05MU6THxuOxPxJwh8mJON2jEIgSFYg.bGTHpgOlDuit6yDeHgSwnrOayPzb-J-bQ1REjBRZE5Ag.JPEG.everyahd1004/20210729%EF%BC%BF131001.jpg?type=w800",7L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA4MDZfMjY5/MDAxNTk2NzA4MzI0NTYy.YPDp8q4T-gTEv1lrSPX6fjiAmwdbU7wanAFabN4bqHkg.twIDmyhaFRPVTOAe4WrTDzfKBLZfknV7pK9zXwMTjFMg.JPEG.rosaceae2001/20200805_132140.jpg?type=w2",7L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTAxMjJfMjkx/MDAxNjExMzIxNzgyNzEy.U11-LWwPptBMzt0E5xx-fkUPKy20gcS9EbcslCOjrVMg.Z52lmS18vKZHfLLihe8eQfMZ0E--PvoUyI103sq7rkgg.JPEG.jhs5149/SE-c71f355c-9465-4a76-8b35-9190deb377ac.jpg?type=w800",7L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA4MjNfMTIy/MDAxNTk4MTgxNjcxMjYy.d70t_HKOctF6Vi2-w7-VkQnIZlci5-KnITjcSurCwJcg.x0qPoHgQEUVTZH_BslBSn_8yHJFHEACmEb9AB_GGvlog.JPEG.luke_suh/DSC04333.jpg?type=w800",7L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMjA1MTVfMTg0/MDAxNjUyNjIxMjk1OTEw.o5XZzUY2yl2FZEbiB2JwVewFury1oSfHVvW9dp3SGq0g.ejh4eb4TPS6NfJmkxzdq_uSGyX6fF7b-_sL0872Yiv0g.JPEG.kifdk/20220514%EF%BC%BF121005.jpg?type=w800",7L);

        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA5MTBfMTA4/MDAxNTk5NzExOTUxOTYw.waxkLifAf1Q5YoCSgcVbEROKTG3IQwB7W4dED-jm194g.zH7FKdqNIZW65veNdka8JOQhZbi9zIPI5YcZxhiy-REg.JPEG.begopa1092/SE-a73ddc58-d9ef-493f-8a21-6015993fc683.jpg?type=w800",8L);
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2020/09/16/m_00528G105726_1.jpg",8L);
        createStoreImageURL("https://fastly.4sqi.net/img/general/600x600/564906471_gbHuJl6JrkNtiXfEzD-vJ-ZPxgYsy9a8W-9x6H8hQJg.jpg",8L);
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2020/09/16/m_00528G110117_1.jpg",8L);
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2020/04/06/m_00528G210517_15.jpg",8L);

        createStoreImageURL("https://emmaru.com/matzip/include/pics/2020/03/13/m_33183K171735_1.jpg",9L);
        createStoreImageURL("https://img.siksinhot.com/place/1643244422714024.jpg?w=307&h=300&c=Y",9L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA2MzBfMjI5/MDAxNjI1MDA3NTM3OTQx.9xLPRbJLrlHjobLiRlZ8593ykkesgwq-ujraBNUrShgg.Xyyxa1eYK_awHYHDbVsdHXG_KSk7ml70SVL2SFHoM0Eg.JPEG.sunw1/20210624_181635.jpg?type=w2",9L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA2MzBfMTQ1/MDAxNjI1MDA3NTM1Nzg1.XAiE2Keo8ar-_5zq1cHd5TwGimmKyOjGf917H_-_JSwg.QfEHMquAemLzbqIjvtwJrpkLuOMkWnOxDDiZMr_lZKsg.JPEG.sunw1/20210624_174850.jpg?type=w2",9L);
        createStoreImageURL("https://mp-seoul-image-production-s3.mangoplate.com/405515/1380338_1637153405592_136323?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",9L);

        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxNzA1MTRfMTAy/MDAxNDk0NzM5NDc3NjIz.Gu5bio9NUeTB9PKw-51YLw1HL-AUM6U57ZxsrKfWmygg.daAN51gZoG-kX7hgie8Vh4apfkBlIel9invZVlXpnuYg.JPEG.yuminaki/DSC00053.jpg?type=w800",10L);
        createStoreImageURL("https://img.siksinhot.com/place/1611020313795379.jpg",10L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxNzA1MTRfMTAy/MDAxNDk0NzM5NDc3NjIz.Gu5bio9NUeTB9PKw-51YLw1HL-AUM6U57ZxsrKfWmygg.daAN51gZoG-kX7hgie8Vh4apfkBlIel9invZVlXpnuYg.JPEG.yuminaki/DSC00053.jpg?type=w800",10L);
        createStoreImageURL("https://img.siksinhot.com/place/1608189114723062.jpg",10L);
        createStoreImageURL("https://img.siksinhot.com/place/1616542575732554.jpeg?w=307&h=300&c=Y",10L);

//        음식점 우연 부터 검색 필요
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA5MzBfMTk1/MDAxNjAxMzkzMzUyNDQz.pgO27EWQro5kQsA7_gM18qZ7Wzho3FzuCbIXzyzgWVQg.C_iSrOv06qgrRt3MdRsMj6UcP-9St--rgR_gpAqHgA4g.JPEG.jjme2020/%EC%A0%84%EC%A3%BC%EC%8B%9C%EB%A7%9B%EC%A7%91%EC%86%A1%EC%B2%9C%EB%8F%99%EC%97%90%EC%BD%94%EC%8B%9C%ED%8B%B0%ED%95%9C%EC%9A%B0%EC%9A%B0%EC%97%B0%EB%A0%88%EC%8A%A4%ED%86%A0%EB%9E%91_(1).JPG?type=w800",11L);
        createStoreImageURL("https://img.siksinhot.com/place/1567750741030303.jpg?w=508&h=412&c=Y",11L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA5MzBfMjMw/MDAxNjAxMzkzMzU0OTUz.0zz6uOOoFJbmwpwQy6cXXZgwpdwVH6Href6C56wHF3kg.S57bhM_RmEMO6z5Ys9Fq_rOmJuQtFNUEluAK_euBPPAg.JPEG.jjme2020/%EC%A0%84%EC%A3%BC%EC%8B%9C%EB%A7%9B%EC%A7%91%EC%86%A1%EC%B2%9C%EB%8F%99%EC%97%90%EC%BD%94%EC%8B%9C%ED%8B%B0%ED%95%9C%EC%9A%B0%EC%9A%B0%EC%97%B0%EB%A0%88%EC%8A%A4%ED%86%A0%EB%9E%91_(4).JPG?type=w800",11L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA5MzBfMTkx/MDAxNjAxNDI5MDgzNDI0.2KBTgbAGh3eINKQVEIlxkd5rxDh5w5WieHwPQ3qYQXEg.cPTRnnf00t_pBwPrjCB0-GXuvZgDeSDirNF68Qp_Qs0g.JPEG.jjme2020/SE-6df39f71-6a85-43c4-b46f-4bccac241009.jpg?type=w800",11L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA5MzBfMjAw/MDAxNjAxMzkzMzUyNjc3.NByBMaN10-v6feHcrxrme6nTOxCTYFyuWqK_6mjIMa4g.x-vTg7KyqEl0rFtq6UShiypONCkq3-AR1T8SUxg_OO8g.JPEG.jjme2020/%EC%A0%84%EC%A3%BC%EC%8B%9C%EB%A7%9B%EC%A7%91%EC%86%A1%EC%B2%9C%EB%8F%99%EC%97%90%EC%BD%94%EC%8B%9C%ED%8B%B0%ED%95%9C%EC%9A%B0%EC%9A%B0%EC%97%B0%EB%A0%88%EC%8A%A4%ED%86%A0%EB%9E%91_(3).JPG?type=w800",11L);
//        이속우화 구우몽
        createStoreImageURL("https://media.bunjang.co.kr/product/171419430_1_1638185260_w360.jpg",12L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/Axmjk/btq65scRTqm/mrUN0zm83epMpgr5duYQuk/img.jpg",12L);
        createStoreImageURL("https://img1.daumcdn.net/thumb/R300x0/?fname=https://k.kakaocdn.net/dn/dyYLVZ/btrv4mrrvdt/Kpa3jvFg8jDQJxBjnEYW41/img.jpg",12L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/CDgGG/btrwJ8ALFGM/p3oV73ER0iQzlZ2Yw2FNLK/img.png",12L);
        createStoreImageURL("https://d12zq4w4guyljn.cloudfront.net/pre_20220522062323_photo2_e76a6569e760.jpg",12L);
//        우화 음식점
        createStoreImageURL("https://blog.kakaocdn.net/dn/1Jg4I/btrpIyEcMe6/fnS8UGUBxiL4w1ujiAlXOK/img.jpg",13L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/cybTfZ/btrpyiCHK1Z/VKrhuIR6r0q91iD4tcOsY1/img.jpg",13L);
//        선정생한우
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxOTA1MTJfMjc2/MDAxNTU3NjI0NjcxNzk2.5TH2X53D7cUU4gFICC8Mx-mk5iVPW3ojnzkwN3xVn_Ig.nypJOgzeaDVO_Zexi18xYG-wqh27BadLmGWZoCW_y2Eg.JPEG.thisdon77/%EC%84%A0%EC%A0%95%EA%B0%84%ED%8C%90.jpg?type=w800",14L);
        createStoreImageURL("https://ldb-phinf.pstatic.net/20160108_53/1452234806144z0A2V_JPEG/176058556345432_0.jpg?type=f804_408_60_sharpen",14L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA0MDJfODEg/MDAxNTg1Nzg5OTg5MDk0.pQ1e12HDbFz-V-tHhEk4uoF0Olq3hZwLXgrpzJ0ZTQcg.Pcyu4V07P-4fUREpnZE6ECNAF-pQi0BzVLNREkWCHksg.JPEG.thisdon77/SE-0d10d5c0-08b8-40e9-95de-878f3293ea82.jpg?type=w800",14L);
        createStoreImageURL("https://t1.daumcdn.net/cfile/blog/99581B445B8995DA27",14L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA0MDJfMTU3/MDAxNTg1NzkwMjE5MjQ3.ibFwYEi69JSmPyO_7k2UJ-G88OrhqhxGWLuJj7OUaNQg.M79BbLPjeu7yAi01td9gngXAR3AwAR5QnQxeHQfZ1RYg.JPEG.thisdon77/SE-ff1b29a3-adb0-41c9-a328-c6e64e52c70a.jpg?type=w800",14L);
//        파불라(PABULLA)
        createStoreImageURL("https://t3.daumcdn.net/thumb/R720x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/5hT6/image/qBPECa9jtctvwE8ZiTf89M7oeuo.jpeg",15L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxNzAzMjdfMTQ0/MDAxNDkwNTY1MTM2MzY5.ZVmMHrGgLvciw_P7DIcOz9jqKa7z8YGEzwNFn2LEegcg.6aUb78AZ7jyZBPRj6DdK7Y6qkP0zHBaiU4LOfG-AZBIg.JPEG.olivia1113/%ED%8C%8C%EB%B6%88%EB%9D%BC_%289%29.JPG?type=w800",15L);
        createStoreImageURL("https://img.siksinhot.com/article/1482809399871237.jpg",15L);
//        한와담 가든
        createStoreImageURL("https://ldb-phinf.pstatic.net/20200713_91/1594615027771JM6Te_JPEG/mrJKVjHpeeBdzWEW3tAVTVJc.jpg?type=f804_408_60_sharpen",16L);
        createStoreImageURL("https://mp-seoul-image-production-s3.mangoplate.com/421035/1171911_1655277433959_17006?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",16L);
        createStoreImageURL("https://img.siksinhot.com/place/1611020475019430.jpg",16L);
        createStoreImageURL("https://img.siksinhot.com/place/1611020475019430.jpg",16L);
        createStoreImageURL("https://mp-seoul-image-production-s3.mangoplate.com/679704_1653550989343350.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",16L);
//        수묵당
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA5MDJfMTcx/MDAxNTk5MDIwNjQ5NzEw.GPA-SOr9CKhxIAU5TvSc-_h_FRUpezDQwfl7rgPAmwIg.e-5eea0WNm0ZIS4J5Kys5KxbtuInLPKcITbGZr9xJKcg.JPEG.vvvvv9897/1.JPG?type=w800",17L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/bW3vzu/btq77vzUsRu/ioUJFI9TKYcYxO42VEkkCk/img.jpg",17L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA5MTlfNzEg/MDAxNjMyMDI1NjU0NzU3.ayQNeK91tdPjqwc2UIx27lBZz4mPy-7TTYMT3BcFahgg.s1oV5FHAR57CLb-JM-08ClsIif3GdmAX4AE-HPKa4vUg.JPEG.pej609/IMG_6528.JPG?type=w800",17L);
        createStoreImageURL("https://mp-seoul-image-production-s3.mangoplate.com/429293/158101_1656643285442_18994?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",17L);
        createStoreImageURL("https://mp-seoul-image-production-s3.mangoplate.com/429293/158101_1656643285442_18995?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",17L);
//        룩소(Luxor)
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA3MjVfODYg/MDAxNjI3MjE0MzY2NjU1._J43seIEJkqjyXnUSQmiS6CPxGCUumtTRuqbJod8SuAg.90kRa55059f70vcFauOmJWif0A862ocFqA3RREnZQcMg.PNG.julism/%EB%8C%80%EC%A0%84%EB%A3%A9%EC%86%8C-3.png?type=w800",18L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA2MDZfMTcw/MDAxNjIyOTM4Mjg1ODg0.LW3i8-0ay4NFyFxSq_XB-Hq1RBd6J8ir5oUIIMedzIcg.XMAia8JDz8Q6X_iQUYCuKPE6da_i72XkNDZoXK9SHZgg.JPEG.wjddls7449/1622938272928.jpg?type=w800",18L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA3MjVfMjk4/MDAxNjI3MjE0MzY2NTU4.tg_ke1WVW-wKQGmJNaJzUtA1mUJqaGac1crS0R4i8Jkg._Ole_1fjMlV4ssUiY_xkN1IKV9nag2Kax6T9edCB60Yg.PNG.julism/%EB%8C%80%EC%A0%84%EB%A3%A9%EC%86%8C-7.png?type=w800",18L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA3MjVfMTA5/MDAxNjI3MjE0MzY2NDc2.FS-RjKR2_C78I49p8yav6C8-KFMZBfyruoEuSHySQ7og.GbDuAkV1fmh8s3MO1T0_ww_xJjLabaF4yXMA4J33js8g.PNG.julism/%EB%8C%80%EC%A0%84%EB%A3%A9%EC%86%8C-6.png?type=w800",18L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA3MjVfMjY2/MDAxNjI3MjE0MzY2Njc4.ka8VjqVdrquWPVCbSA_9E_ofFx009itAj3cLXZ9bry4g.YJWpwD8wSriqaLg64DPNb2cW-Shzkfy6ZhVzoxMUqnUg.PNG.julism/%EB%8C%80%EC%A0%84%EB%A3%A9%EC%86%8C-4.png?type=w800",18L);
//        마마램
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA0MjJfNTMg/MDAxNTg3NTIyMTQ5ODE3.oG8hYsBKmmo2avjwK0PqilV9EOzB0n1Z7lJOgz0_2log.qSsOOpg8sRW87tCpfa6KGmMds8ryyME5LZ33b6spP3sg.JPEG.wony_91/P20200421_202731382_1B657AB2-AE28-48B4-A0CE-768FC209A4F0.JPG?type=w800",19L);
        createStoreImageURL("https://img.siksinhot.com/place/1616546871443663.jpeg?w=307&h=300&c=Y",19L);
        createStoreImageURL("https://ldb-phinf.pstatic.net/20200401_230/1585705552612LXdyp_JPEG/-mmGfFbfuv1MPGQxii2T4DHL.jpeg.jpg?type=f804_408_60_sharpen",19L);
        createStoreImageURL("https://img.siksinhot.com/place/1616546882551665.jpeg?w=307&h=300&c=Y",19L);
        createStoreImageURL("https://img.siksinhot.com/place/1616546877043664.jpeg?w=307&h=300&c=Y",19L);
//        청담동 참치명가
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA1MjJfMjA0/MDAxNTkwMTAzNTkxNjkw.5Pd-ADGe7wLK6jbEuF782dlQgBiXBtQaURJgVZwHFf0g.koDm0ocig6KnrfulUjOEIfEFNk6NYxqIpYs6hqMgfH8g.JPEG.choijg0921/1590103590953.JPG?type=w800",20L);
        createStoreImageURL("https://steemitimages.com/640x0/https://cdn.steemitimages.com/DQmbn5iHukaSQEegxWAmoNiCoQzWD63vQ7TQjR1kUR1ZRAE/1624113340719.jpg",20L);
        createStoreImageURL("https://steemitimages.com/640x0/https://cdn.steemitimages.com/DQmbn5iHukaSQEegxWAmoNiCoQzWD63vQ7TQjR1kUR1ZRAE/1624113340719.jpg",20L);
        createStoreImageURL("https://steemitimages.com/640x0/https://cdn.steemitimages.com/DQmaB8PLV1BM3UensYNpnNMQxayT2wQ8F2NNMN3WL4EC6fX/1624113342156.jpg",20L);
        createStoreImageURL("https://steemitimages.com/640x0/https://cdn.steemitimages.com/DQmTXHTjscmcmN2wZj9GiayHF4kFNzqhvxfPyhzXvmDGqeb/1624113345282.jpg",20L);
//        바베큐쉑
        createStoreImageURL("https://media-cdn.tripadvisor.com/media/photo-s/19/f9/6b/77/caption.jpg",21L);
        createStoreImageURL("https://media-cdn.tripadvisor.com/media/photo-s/08/a4/2a/01/getlstd-property-photo.jpg",21L);
        createStoreImageURL("https://media-cdn.tripadvisor.com/media/photo-s/0f/0a/05/12/caption.jpg",21L);
//        키친마이야르
        createStoreImageURL("https://image.toast.com/aaaaaqx/catchtable/shopinfo/s22995/22995_221514025533893.png",22L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMjAyMThfMjU0/MDAxNjQ1MTg4Mjg4NzIy.vQSh8B5B_-hLOWYwvBO4ciD0YcSx45uR1xBAVUF1HFQg.CSVd0BIe_sAnuRqEHCHwcrO7ytbSGqUE29fWyHSBwGog.JPEG.nowwegom/R0008764-2.jpg?type=w800",22L);
        createStoreImageURL("https://image.fmkorea.com/files/attach/new2/20220507/494354581/3811407921/4592382892/1b5c1e1c3f1819d62d98d94860b414ee.jpg",22L);
        createStoreImageURL("https://serieamania.com/g2/data/file/freetalk/mania-done-1642062431_kh6vWTVr_20220113_133150.jpg",22L);
        createStoreImageURL("https://image.fmkorea.com/files/attach/new2/20220113/3655304/2846830850/4248980196/bbd653f7c8c6237453ce76b06ab216dc.jpg",22L);
//        MAISON HANNAM
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTAzMTlfMTcy/MDAxNjE2MTM3MjgxNzEx.JRWOuFqTXBzwEeHHI7AlRg-AFLF3hk_GsXU8gpMHyAwg.r76lEGJwvbscuuNe7HmbnhFMV5Rn48wMq_rHk0WTD2sg.JPEG.hyunzinkim/SE-9063464f-8f31-4fc1-864f-8ece2f8a1176.jpg?type=w800",23L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA0MDRfNTUg/MDAxNTg1OTY5MTAzNTc2.flA3uagOGTlLoNQXJndZGcsVsQgUpnABP77XqEhmhMwg.A5d5IscR0pume0hsDCcMRFtkEQ3C_miaDBqfVHfSMcUg.JPEG.joeuning/IMG_9167.jpg?type=w800",23L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/bfkaiF/btrsxh0XDQn/KfWywffuBGamAXgKriRdB1/img.jpg",23L);
        createStoreImageURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTynPBAyXUYgIaQSTv45wQdEM4fH-zQNgBY9A&usqp=CAU",23L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDExMTdfMjQ3/MDAxNjA1NjEyNjUyOTg1.iJ2aVpmKP7naxivXif01D6ttPaGlU-wj2NR5EJa3bIEg.mqOl8jFf5QwwRHktFPPEZMU6ZUV7za2yczljTspjXjog.JPEG.jenny0228/IMG_2719.JPG?type=w800",23L);
//        웨스틴조선서울 아리아
        createStoreImageURL("https://cdn-prod.marriottbonvoyasia.kr/prod.misolhub.com/uploads/benefits/cms/outlet/eG9Y5j1ihhRM.jpg",24L);
        createStoreImageURL("https://image.toast.com/aaaaaqx/catchtable/shopinfo/s21102/21102_2212115111655694.png",24L);
        createStoreImageURL("https://t1.daumcdn.net/cfile/tistory/99FC5B495B86869307",24L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDAxMjZfMTQ0/MDAxNTgwMDQxNTA1NzYy.MWpGp9oDIg4P5-iEyoAYN62ZqF1_2NEMAlvLc3PYzFkg.7ed5I2Ysfen5vNg1HwvksK6hjyRnm4CIlne2Q-dwq8Mg.JPEG.tometome123/1580041504870.jpg?type=w800",24L);
        createStoreImageURL("https://t1.daumcdn.net/cfile/tistory/271A044153C3D0A104",24L);
//        오스테리아 오르조
        createStoreImageURL("https://img.maisonkorea.com/2017/11/msk_59fa888158c75-1024x683.jpg",25L);
        createStoreImageURL("http://www.foodwork.co.kr/EmployImages/366v8C4o8G2.jpg",25L);
        createStoreImageURL("https://pbs.twimg.com/media/DaguQ_TVwAE4F8p.jpg:large",25L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxODA4MTNfMTEy/MDAxNTM0MTE5NDMyMjY1.yP0e74-UeXfrlExQBP194bYJr_ujws-Zxamn_sBKEnIg.ajAbZxnxjwhstpBrd43dUEhL01ClvGskDidp9jYFirwg.JPEG.koreanstyl3/CL9I9985.JPG?type=w800",25L);
        createStoreImageURL("https://www.hyundaicard.com/upload/cpd/cs/2_1643277706005.jpg",25L);
//        바위파스타바
        createStoreImageURL("https://emmaru.com/matzip/include/pics/2020/09/25/m_73383C093358_1.jpg",26L);
        createStoreImageURL("https://blog.kakaocdn.net/dn/nwEo3/btqOzB6aoDE/C6XddlJOQkKlwqD3P3BpKk/img.png",26L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDA0MTZfMTk0/MDAxNTg2OTY0OTQxMTc4.JumPUBkG5JQva2xPYidWnHR2DfhNGVkOgmO4xSLZTvcg.LudqY0kUKHo0LMI-tQ99udWJ1-4yKB0IRDrMnNuu56Mg.JPEG.bewhite12/DSC03699.jpg?type=w800",26L);
//        괴르츠
        createStoreImageURL("https://street-h.com/wp-content/uploads/2015/02/%EA%B4%B4%EB%A5%B4%EC%B8%A0_20141109_05.jpg",27L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxOTAxMjBfMSAg/MDAxNTQ3OTUwMzA2NjU4.EEonW61h8Zx1ktm1WA9IZw_JMVVTSLXy3PCJJhqOA2Ig.1RKZms4ga4AxWruFoPAkqGWJiNfE2GxF49LG8xWPm2kg.JPEG.rolo_ggo/SE-4352cfa4-e831-4464-b5cb-aade7b78738e.jpg?type=w800",27L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/20160919_114/saranghae_kk_1474270608051rixWe_JPEG/P20160917_183838033_42F99B3C-C80A-458B-AEB3-5B1CFE72DB76.JPG?type=w800",27L);
        createStoreImageURL("https://image.toast.com/aaaaaqx/catchtable/shopinfo/s3635/3635_19121419585986463.jpg",27L);
//        라쿠치나
        createStoreImageURL("https://t1.daumcdn.net/cfile/tistory/213ADF3A524DBE5222",28L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDAyMDRfMTg0/MDAxNTgwODEyNDg1NzM4.0RINjKDBrpFJtHIwjMU6nRlqcSg0KT5jk5KzYYAYaSQg.d0yvPUvh3i_HqsbV60tkgkLvFs2UtNRNSETqg7Q9K6Ig.JPEG.tiffanyflower/SE-aa353ba6-f4e9-45f7-a3d4-dad0339192a2.jpg?type=w800",28L);
        createStoreImageURL("https://image.toast.com/aaaaaqx/catchtable/shopinfo/s2669/2669_19102314393628024.jpg",28L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxOTA3MjRfMTA0/MDAxNTYzODk5MzU3NDQy.YC1JIlQqlXUN3yZk3pgRXNj7qi4faxUatow128jswMEg.q2cOKK4XYXzawciPWE_f9A9-M-6t2nucWCHbVSaVOPsg.JPEG.elixir0827/20190716_184544.jpg?type=w800",28L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDAyMDRfMTU3/MDAxNTgwODEyNDY4MDky.Givh_xD8YC5XfvupDitXT9C3Xrh0tZvzJoc9GKQpXe4g.dcM2Pv70mtmgqNH9aYaQuJToS5PsPzn0Tf7D5vX2tPEg.JPEG.tiffanyflower/SE-b67ac828-df4c-4f6b-a78a-19e1022df844.jpg?type=w800",28L);
//        러반로제 레스토랑
        createStoreImageURL("https://d12zq4w4guyljn.cloudfront.net/pre_20190720102718538_photo_08c3ba974c8c.jpg",29L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMTA0MDdfMTQy/MDAxNjE3ODAzMDc5Mjc5.QHgztFx7CMyzZb8WVZfKBq4J0UbT9rHk7SDyBQfJnxEg.u0O4ztSeiQyL-q4nfO9Xk-90P7YKdYANXJ2V4Eje7BAg.JPEG.jibi1108/IMG_9149.JPG?type=w800",29L);
        createStoreImageURL("https://d12zq4w4guyljn.cloudfront.net/pre_20190720102718600_photo_08c3ba974c8c.jpg",29L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAyMDEwMjJfMjUx/MDAxNjAzMzc3NTg0NTgw.naTDEGaA4wSUQA2naDI3WNuzj0ZGX1clKY-MFwdZ574g.J7FnACuDvegZlQBMEqAACUsW813DCCwk_MD5HTNLg0gg.JPEG.vivaceren/KakaoTalk_20201022_224539919_09.jpg?type=w800",29L);
//        가스트로통
        createStoreImageURL("https://file.mk.co.kr/meet/neds/2018/01/image_readtop_2018_47260_15165800353177374.jpg",30L);
        createStoreImageURL("https://img.siksinhot.com/place/1638152676407226.jpg?w=307&h=300&c=Y",30L);
        createStoreImageURL("https://wine21.speedgabia.com/uploaded/imgs/300/1315989138.jpg",30L);
//        스톤힐
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxNzAyMTFfMjQ5/MDAxNDg2NzM5OTY0MTE1.UYwv_Ks0Rcfp_xmh2hJncLP8Fe1PKAltfuDLA8fYDbYg.6lvqm5vL14sRHsf1dxCsOVtqYgBqSCHJAhUL4yUphr8g.JPEG.mobuu/image_826236481486739480155.jpg?type=w800",31L);
        createStoreImageURL("https://mp-seoul-image-production-s3.mangoplate.com/27597_1580547235223803.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",31L);
        createStoreImageURL("https://t1.daumcdn.net/cfile/tistory/225A0E4858AA79B034",31L);
        createStoreImageURL("https://mblogthumb-phinf.pstatic.net/MjAxNzExMDhfMTgg/MDAxNTEwMDkwOTE1Njky.sl3dKqpyEFKziXpw70yduaVmG0wRTDXVTU6ztYw1mbgg.M9V5mpzINcMTYsyPAzXn8WEKshNuVDNAsRO3ywsgBVQg.JPEG.erin0121/image_3755740311510087663889.jpg?type=w800",31L);
    }

//    가게 정보 등록
    private void createTestData(String storename, String category, String region, String launchPrice, String dinnerPrice, String phone, String descrpition, Float Lat, Float lng) throws IOException {
        // 가게 정보 등록
        storeResponseDto.setStorename(storename);
        storeResponseDto.setCategory(category);
        storeResponseDto.setRegion(region);
        storeResponseDto.setLaunchPrice(launchPrice);
        storeResponseDto.setDinnerPrice(dinnerPrice);
        storeResponseDto.setPhone(phone);
        storeResponseDto.setDescription(descrpition);
        storeResponseDto.setLat(Lat);
        storeResponseDto.setLng(lng);

        Store store = new Store(storeResponseDto);
        storeRepository.save(store);
    }

    // 식당 이미지 등록
    public void createStoreImageURL(String storeImagePath, Long id) {
        Store store  = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("점포를 찾을수가 없습니다.")
        );
        storeImageDto.setImagePath(storeImagePath);
        StoreImageURL storeImageURL = new StoreImageURL(storeImageDto);
        // 양방향 매핑을 시도시 에러 발생
        // 해결 참고 자료 - https://www.inflearn.com/questions/33949 - @Transactional 추가후 해결
        store.addStoreImageURL(storeImageURL);
        storeImageRepository.save(storeImageURL);
    }
}
