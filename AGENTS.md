# AGENTS.md — quy tắc cho AI coding agent

Repo THỬ cho demo agentlab. Không chứa code hay bí mật của khách hàng.

## Build / test

- Java 17 (`maven.compiler.release=17`), Maven 3.9.
- Chạy test: `mvn -B test`
- Build đầy đủ: `mvn -B verify`
- Mọi thay đổi phải giữ `mvn -B test` xanh; thêm test cho hành vi mới.

## Quy ước

- Package gốc: `vn.agentlab.demo`. Mã nguồn ở `src/main/java`, test ở `src/test/java` (JUnit 5).
- Thụt lề 4 dấu cách, xuống dòng LF, UTF-8.
- Thay đổi nhỏ, tập trung đúng yêu cầu; không đổi tên/di chuyển file không liên quan.
- Không thêm dependency mới nếu đề bài không yêu cầu.

## Cấm sửa

- `.github/` (CI/workflow), `.gitattributes`, `AGENTS.md`, `CLAUDE.md`.
- Bất kỳ file cấu hình bí mật nào (`.env*`, `*credentials*`, `*.pem`, `*.key`).
- Không tự `git commit` / `git push`: script điều phối làm phần git.
