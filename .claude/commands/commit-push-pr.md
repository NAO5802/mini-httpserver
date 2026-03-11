# コミット・プッシュ・PR作成

現在のブランチに対して、CLAUDE.md の規約に従ってコミットを作成し、リモートへプッシュした後、Pull Request を作成する。

## 前提条件

- GitHub CLI (`gh`) がインストール済みであること
- リモート `origin` が設定済みであること

## 実行手順

### 1. ブランチ確認

```bash
git branch --show-current
```

- main/master の場合は CLAUDE.md の制限に従い終了

### 2. 差分確認（並列実行）

```bash
git status
git diff
git diff --cached
git log --oneline -5
```

- 変更がない場合は「コミット対象の変更がありません」と報告して終了

### 3. 変更内容の分析

- 差分から変更の種類を判断
- コミットメッセージと PR 内容を検討

### 4. ステージング

```bash
git add -A
```

### 5. コミット作成

CLAUDE.md の規約に従ってコミットを作成する。

### 6. プッシュ

```bash
git push -u origin <current-branch>
```

### 7. PR作成

```bash
git log origin/main..HEAD --oneline
git diff origin/main...HEAD --stat
```

上記で差分を確認し、`gh pr create` で PR を作成する。

### 8. 結果確認・報告

- 作成された PR の URL をユーザーに報告
