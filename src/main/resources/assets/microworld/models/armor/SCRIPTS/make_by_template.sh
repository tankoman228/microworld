#!/bin/bash

# Список материалов
materials=("cilliary")

# Список частей брони
armor_parts=("boots" "leggings" "chestplate" "helmet")

# Список типов отделки
trims=("quartz" "iron" "netherite" "redstone" "copper" "gold" "emerald" "diamond" "lapis" "amethyst")

# Создаем обычную модель для каждого материала и части брони
# Создаем обычную модель для каждого материала и части брони
for material in "${materials[@]}"; do
    for part in "${armor_parts[@]}"; do
        model_file="${material}_${part}.json"
        echo "Создаем файл: $model_file"
        
        echo '{
  "parent": "minecraft:item/generated",
  "overrides": [' > "$model_file"
        
        for i in "${!trims[@]}"; do
            trim="${trims[$i]}"
            # Меняем формат на 0.1, 0.2, ..., 1.0
            trim_type=$(awk "BEGIN { printf \"%.1f\", ($i + 1) / 10 }")
            echo "    {
      \"model\": \"microworld:item/${material}_${part}_${trim}_trim\",
      \"predicate\": {
        \"minecraft:trim_type\": $trim_type
      }
    }$(if [ $i -lt $(( ${#trims[@]} - 1 )) ]; then echo ','; fi)" >> "$model_file"
        done
        
        echo '  ],
  "textures": {
    "layer0": "microworld:item/'"${material}"'_'${part}'"
  }
}' >> "$model_file"
    done
done



# Создаем модель для типов отделки отдельно
for material in "${materials[@]}"; do
    for part in "${armor_parts[@]}"; do
        for trim in "${trims[@]}"; do
            trim_file="${material}_${part}_${trim}_trim.json"
            echo "Создаем файл: $trim_file"

            echo '{
  "parent": "minecraft:item/generated",
  "textures": {
    "layer0": "microworld:item/'"${material}"'_'${part}'",
    "layer1": "minecraft:trims/items/'${part}'_trim_'${trim}'"
  }
}' > "$trim_file"
        done
    done
done

echo "Файлы успешно сгенерированы! 🛠️"


