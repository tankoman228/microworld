#!/bin/sh

# Перебираем все .json файлы в текущей директории
for file in *.json; do
    # Извлекаем название файла без расширения
    filename=$(basename "$file" .json)
    
    # Создаём новое содержимое
    new_content=$(cat <<EOF
{
    "parent": "item/generated",
    "textures": {
        "layer0": "microworld:item/$filename"
    }
}
EOF
)
    
    # Записываем новое содержимое в файл
    echo "$new_content" > "$file"
    
    echo "Файл $file обновлен."
done

echo "Все файлы обновлены!"

