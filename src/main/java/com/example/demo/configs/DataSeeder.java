package com.example.demo.configs;

import com.example.demo.models.Manga.Category;
import com.example.demo.models.Manga.Manga;
import com.example.demo.models.Manga.MangaStatus;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final MangaRepository mangaRepository;

    @Override
    public void run(String... args) {

        if (mangaRepository.count() > 0) {
            return;
        }

        List<String> categoryNames = List.of(
                "Action", "Adventure", "Comedy", "Drama", "Romance",
                "School Life", "Horror", "Fantasy", "Sci-fi", "Sport",
                "Mystery", "Slice of Life", "Historical", "Reincarnation",
                "Manhua", "Cultivation", "Manhwa", "Shounen"
        );

        List<Category> categories;

        if (categoryRepository.count() > 0) {
            categories = categoryRepository.findAll();
        } else {
            categories = categoryNames.stream()
                    .map(name -> {
                        Category category = new Category();
                        category.setName(name);
                        return category;
                    })
                    .map(categoryRepository::save)
                    .toList();
        }

        createManga(
                "Solo Leveling",
                "solo-leveling",
                "Sung Jin-Woo là thợ săn yếu nhất hạng E. Sau khi suýt chết trong một ngục tối kép, anh nhận được hệ thống cho phép nâng cấp sức mạnh không giới hạn.",
                "https://picsum.photos/seed/manga1/200/280",
                "https://picsum.photos/seed/banner1/800/400",
                "Chugong",
                "Korea",
                MangaStatus.COMPLETED,
                179,
                2450000L,
                4.8,
                12500,
                true,
                true,
                false,
                categories,
                List.of(1, 8, 17)
        );

        createManga(
                "One Piece",
                "one-piece",
                "Monkey D. Luffy cùng băng Mũ Rơm lên đường tìm kho báu One Piece để trở thành Vua Hải Tặc.",
                "https://picsum.photos/seed/manga2/200/280",
                "https://picsum.photos/seed/banner2/800/400",
                "Oda Eiichiro",
                "Japan",
                MangaStatus.ONGOING,
                1120,
                5200000L,
                4.9,
                25000,
                true,
                true,
                false,
                categories,
                List.of(1, 2, 18)
        );

        createManga(
                "Jujutsu Kaisen",
                "jujutsu-kaisen",
                "Itadori Yuji nuốt ngón tay của Ryomen Sukuna và trở thành vật chứa của Vua Chú Thuật.",
                "https://picsum.photos/seed/manga3/200/280",
                "https://picsum.photos/seed/banner3/800/400",
                "Akutami Gege",
                "Japan",
                MangaStatus.COMPLETED,
                271,
                3100000L,
                4.7,
                18000,
                true,
                true,
                false,
                categories,
                List.of(1, 7, 18)
        );

        createManga(
                "Tower of God",
                "tower-of-god",
                "Bam bước vào Tháp Thần để tìm lại Rachel - người bạn duy nhất của mình.",
                "https://picsum.photos/seed/manga4/200/280",
                "https://picsum.photos/seed/banner4/800/400",
                "SIU",
                "Korea",
                MangaStatus.ONGOING,
                580,
                1800000L,
                4.6,
                9500,
                false,
                false,
                false,
                categories,
                List.of(1, 2, 8, 17)
        );

        createManga(
                "Naruto",
                "naruto",
                "Uzumaki Naruto - cậu bé chứa Cửu Vĩ Hồ mơ ước trở thành Hokage.",
                "https://picsum.photos/seed/manga5/200/280",
                "https://picsum.photos/seed/banner5/800/400",
                "Kishimoto Masashi",
                "Japan",
                MangaStatus.COMPLETED,
                700,
                4800000L,
                4.8,
                22000,
                false,
                false,
                false,
                categories,
                List.of(1, 2, 18)
        );
        createManga(
                "Thanh Gươm Diệt Quỷ",
                "thanh-guom-diet-quy",
                "Tanjiro Kamado lên đường tìm cách cứu em gái Nezuko đã bị biến thành quỷ.",
                "https://picsum.photos/seed/manga6/200/280",
                "https://picsum.photos/seed/banner6/800/400",
                "Gotouge Koyoharu",
                "Japan",
                MangaStatus.COMPLETED,
                205,
                3800000L,
                4.7,
                19000,
                false,
                false,
                false,
                categories,
                List.of(1, 7, 13, 18)
        );

        createManga(
                "Đấu La Đại Lục",
                "dau-la-dai-luc",
                "Đường Tam chuyển sinh sang thế giới võ hồn và bắt đầu hành trình trở thành Hồn Sư huyền thoại.",
                "https://picsum.photos/seed/manga7/200/280",
                "https://picsum.photos/seed/banner7/800/400",
                "Đường Gia Tam Thiếu",
                "China",
                MangaStatus.ONGOING,
                450,
                2100000L,
                4.5,
                8700,
                true,
                false,
                true,
                categories,
                List.of(1, 8, 15, 16)
        );

        createManga(
                "Attack on Titan",
                "attack-on-titan",
                "Nhân loại sống sau những bức tường khổng lồ để tránh Titan.",
                "https://picsum.photos/seed/manga9/200/280",
                "https://picsum.photos/seed/banner9/800/400",
                "Isayama Hajime",
                "Japan",
                MangaStatus.COMPLETED,
                139,
                4200000L,
                4.8,
                20000,
                false,
                true,
                false,
                categories,
                List.of(1, 4, 18)
        );

        createManga(
                "Omniscient Reader",
                "omniscient-reader",
                "Kim Dokja là độc giả duy nhất biết kết thúc của thế giới tiểu thuyết đang trở thành hiện thực.",
                "https://picsum.photos/seed/manga10/200/280",
                "https://picsum.photos/seed/banner10/800/400",
                "Sing Shong",
                "Korea",
                MangaStatus.ONGOING,
                178,
                1900000L,
                4.7,
                11000,
                true,
                false,
                false,
                categories,
                List.of(1, 2, 8, 17)
        );

        createManga(
                "Spy x Family",
                "spy-x-family",
                "Điệp viên Twilight phải tạo một gia đình giả để thực hiện nhiệm vụ bí mật.",
                "https://picsum.photos/seed/manga11/200/280",
                "https://picsum.photos/seed/banner11/800/400",
                "Endo Tatsuya",
                "Japan",
                MangaStatus.ONGOING,
                102,
                2800000L,
                4.6,
                14000,
                true,
                false,
                false,
                categories,
                List.of(1, 3, 12, 18)
        );

        createManga(
                "Chainsaw Man",
                "chainsaw-man",
                "Denji hợp nhất với Pochita và trở thành Chainsaw Man.",
                "https://picsum.photos/seed/manga13/200/280",
                "https://picsum.photos/seed/banner13/800/400",
                "Fujimoto Tatsuki",
                "Japan",
                MangaStatus.ONGOING,
                180,
                3500000L,
                4.6,
                16000,
                true,
                false,
                false,
                categories,
                List.of(1, 4, 7, 18)
        );

        createManga(
                "My Hero Academia",
                "my-hero-academia",
                "Midoriya Izuku nhận sức mạnh One For All và bước vào con đường trở thành anh hùng.",
                "https://picsum.photos/seed/manga14/200/280",
                "https://picsum.photos/seed/banner14/800/400",
                "Horikoshi Kohei",
                "Japan",
                MangaStatus.COMPLETED,
                430,
                3200000L,
                4.5,
                15000,
                false,
                false,
                false,
                categories,
                List.of(1, 6, 18)
        );

        createManga(
                "Vạn Cổ Chí Tôn",
                "van-co-chi-ton",
                "Lý Thiên Mệnh tái sinh trở lại với toàn bộ ký ức và bắt đầu hành trình đứng trên đỉnh cao.",
                "https://picsum.photos/seed/manga15/200/280",
                "https://picsum.photos/seed/banner15/800/400",
                "Thái Thượng Bố Y",
                "China",
                MangaStatus.ONGOING,
                520,
                1600000L,
                4.4,
                7800,
                false,
                false,
                true,
                categories,
                List.of(1, 8, 15, 16)
        );

        createManga(
                "Blue Lock",
                "blue-lock",
                "Dự án Blue Lock tập hợp các tiền đạo trẻ để tìm ra tiền đạo số một thế giới.",
                "https://picsum.photos/seed/manga17/200/280",
                "https://picsum.photos/seed/banner17/800/400",
                "Kaneshiro Muneyuki",
                "Japan",
                MangaStatus.ONGOING,
                280,
                2100000L,
                4.6,
                10500,
                true,
                false,
                false,
                categories,
                List.of(10, 18)
        );

        createManga(
                "Lookism",
                "lookism",
                "Park Hyung-seok thức dậy trong một cơ thể đẹp trai và cuộc sống hoàn toàn thay đổi.",
                "https://picsum.photos/seed/manga18/200/280",
                "https://picsum.photos/seed/banner18/800/400",
                "Park Tae-joon",
                "Korea",
                MangaStatus.ONGOING,
                490,
                1500000L,
                4.5,
                8200,
                false,
                false,
                false,
                categories,
                List.of(1, 6, 12, 17)
        );

        createManga(
                "Death Note",
                "death-note",
                "Light Yagami nhặt được cuốn sổ tử thần và bắt đầu cuộc đối đầu trí tuệ với thám tử L.",
                "https://picsum.photos/seed/manga20/200/280",
                "https://picsum.photos/seed/banner20/800/400",
                "Ohba Tsugumi",
                "Japan",
                MangaStatus.COMPLETED,
                108,
                3900000L,
                4.9,
                21000,
                false,
                true,
                false,
                categories,
                List.of(7, 11, 18)
        );

        createManga(
                "Beginning After The End",
                "beginning-after-the-end",
                "Vua Arthur Leywin tái sinh vào thế giới mới với ký ức kiếp trước.",
                "https://picsum.photos/seed/manga22/200/280",
                "https://picsum.photos/seed/banner22/800/400",
                "TurtleMe",
                "Korea",
                MangaStatus.ONGOING,
                200,
                1700000L,
                4.7,
                9800,
                true,
                false,
                false,
                categories,
                List.of(1, 2, 8, 15, 17)
        );

        createManga(
                "Võ Luyện Đỉnh Phong",
                "vo-luyen-dinh-phong",
                "Dương Khai từ một tên quét rác dần tu luyện thành cường giả tuyệt đỉnh.",
                "https://picsum.photos/seed/manga23/200/280",
                "https://picsum.photos/seed/banner23/800/400",
                "Mạc Mặc",
                "China",
                MangaStatus.ONGOING,
                650,
                2300000L,
                4.5,
                11500,
                true,
                false,
                true,
                categories,
                List.of(1, 8, 14, 16)
        );

        createManga(
                "Frieren - Pháp Sư Tiễn Táng",
                "frieren",
                "Sau khi đánh bại Ma Vương, pháp sư Frieren bắt đầu hành trình tìm hiểu con người.",
                "https://picsum.photos/seed/manga24/200/280",
                "https://picsum.photos/seed/banner24/800/400",
                "Yamada Kanehito",
                "Japan",
                MangaStatus.ONGOING,
                135,
                2600000L,
                4.9,
                13500,
                true,
                true,
                false,
                categories,
                List.of(2, 8, 12, 18)
        );

        createManga(
                "Thế Giới Hoàn Mỹ",
                "the-gioi-hoan-my",
                "Thạch Hạo bị đoạt mất xương tối thượng và phải tự mình tu luyện lại từ đầu.",
                "https://picsum.photos/seed/manga19/200/280",
                "https://picsum.photos/seed/banner19/800/400",
                "Thần Đông",
                "China",
                MangaStatus.ONGOING,
                290,
                890000L,
                4.4,
                5100,
                false,
                false,
                true,
                categories,
                List.of(1, 8, 14, 16)
        );
    }

    private void createManga(
            String title,
            String slug,
            String description,
            String coverImage,
            String bannerImage,
            String author,
            String country,
            MangaStatus status,
            Integer chapterCount,
            Long views,
            Double averageRating,
            Integer ratingCount,
            Boolean hot,
            Boolean featured,
            Boolean newManga,
            List<Category> allCategories,
            List<Integer> categoryIds
    ) {
        Manga manga = new Manga();

        manga.setTitle(title);
        manga.setSlug(slug);
        manga.setDescription(description);
        manga.setCoverImage(coverImage);
        manga.setBannerImage(bannerImage);
        manga.setAuthor(author);
        manga.setCountry(country);
        manga.setStatus(status);
        manga.setChapterCount(chapterCount);
        manga.setViews(views);
        manga.setAverageRating(averageRating);
        manga.setRatingCount(ratingCount);
        manga.setHot(hot);
        manga.setFeatured(featured);
        manga.setNewManga(newManga);
        manga.setApproved(true);

        Set<Category> mangaCategories = new HashSet<>();

        for (Integer id : categoryIds) {
            mangaCategories.add(allCategories.get(id - 1));
        }

        manga.setCategories(mangaCategories);

        mangaRepository.save(manga);
    }
}